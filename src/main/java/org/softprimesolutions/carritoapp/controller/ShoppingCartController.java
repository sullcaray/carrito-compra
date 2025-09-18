package org.softprimesolutions.carritoapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.Principal;

import org.softprimesolutions.carritoapp.model.*;
import org.softprimesolutions.carritoapp.service.ProductService;
import org.softprimesolutions.carritoapp.service.ShoppingCartDetailService;
import org.softprimesolutions.carritoapp.service.ShoppingCartService;
import org.softprimesolutions.carritoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartDetailService shoppingCartDetailService;

    private List<ShoppingCartDetail> details = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @PostMapping("/cart/add")
    public String addCart(@RequestParam("id") Integer id,
                         @RequestParam("quantity") Integer quantity,
                         Principal principal,
                         RedirectAttributes redirectAttributes) {

        if (principal == null) {
            redirectAttributes.addFlashAttribute("error", "Debe iniciar sesión para agregar productos al carrito");
            return "redirect:/login";
        }

        try {
            Product product = productService.findById(id);

            // Verificar si el producto ya existe en el carrito temporal
            boolean found = false;
            for (ShoppingCartDetail detail : details) {
                if (detail.getProduct().getId().equals(id)) {
                    detail.setQuantity(detail.getQuantity() + quantity);
                    detail.setSubtotal(detail.getPrice().multiply(BigDecimal.valueOf(detail.getQuantity())));
                    found = true;
                    break;
                }
            }

            if (!found) {
                ShoppingCartDetail detail = new ShoppingCartDetail();
                detail.setProduct(product);
                detail.setQuantity(quantity);
                detail.setPrice(product.getPrice());
                detail.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
                details.add(detail);
            }

            redirectAttributes.addFlashAttribute("success", "Producto agregado al carrito exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al agregar producto al carrito");
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        BigDecimal total = BigDecimal.ZERO;
        for (ShoppingCartDetail detail : details) {
            total = total.add(detail.getSubtotal());
        }

        model.addAttribute("cart", details);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("id") Integer productId,
                                RedirectAttributes redirectAttributes) {
        details.removeIf(detail -> detail.getProduct().getId().equals(productId));
        redirectAttributes.addFlashAttribute("success", "Producto eliminado del carrito");
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam("id") Integer productId,
                            @RequestParam("quantity") Integer quantity,
                            RedirectAttributes redirectAttributes) {
        for (ShoppingCartDetail detail : details) {
            if (detail.getProduct().getId().equals(productId)) {
                if (quantity <= 0) {
                    details.remove(detail);
                } else {
                    detail.setQuantity(quantity);
                    detail.setSubtotal(detail.getPrice().multiply(BigDecimal.valueOf(quantity)));
                }
                break;
            }
        }
        redirectAttributes.addFlashAttribute("success", "Carrito actualizado");
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        if (details.isEmpty()) {
            return "redirect:/cart";
        }

        BigDecimal total = BigDecimal.ZERO;
        for (ShoppingCartDetail detail : details) {
            total = total.add(detail.getSubtotal());
        }

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("cart", details);
        model.addAttribute("total", total);
        model.addAttribute("user", user);
        return "checkout";
    }

    @PostMapping("/cart/checkout")
    public String processCheckout(Principal principal,
                                 @RequestParam("cardholder") String cardholder,
                                 @RequestParam("cardNumber") String cardNumber,
                                 @RequestParam("expireDate") String expireDate,
                                 @RequestParam("securityCode") String securityCode,
                                 RedirectAttributes redirectAttributes) {

        if (principal == null) {
            return "redirect:/login";
        }

        try {
            User user = userService.findByUsername(principal.getName());

            // Crear el carrito de compras
            ShoppingCart cart = new ShoppingCart();
            cart.setUser(user);
            cart.setDate(new Date());

            BigDecimal total = BigDecimal.ZERO;
            for (ShoppingCartDetail detail : details) {
                total = total.add(detail.getSubtotal());
            }
            cart.setTotalAmount(total);

            // Guardar el carrito
            ShoppingCart savedCart = shoppingCartService.save(cart);

            // Guardar los detalles del carrito
            for (ShoppingCartDetail detail : details) {
                detail.setShoppingCart(savedCart);
                shoppingCartDetailService.save(detail);
            }

            // Crear el detalle de pago
            PaymentDetail paymentDetail = new PaymentDetail();
            paymentDetail.setShoppingCart(savedCart);
            paymentDetail.setCardholder(cardholder);
            paymentDetail.setCardNumber(cardNumber);
            paymentDetail.setExpireDate(expireDate);
            paymentDetail.setSecurityCode(securityCode);
            paymentDetail.setPaymentMethod("CREDIT_CARD");
            paymentDetail.setPaymentStatus("COMPLETED");

            // Limpiar el carrito temporal
            details.clear();

            redirectAttributes.addFlashAttribute("success", "Compra realizada exitosamente");
            return "redirect:/success";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al procesar la compra: " + e.getMessage());
            return "redirect:/checkout";
        }
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
