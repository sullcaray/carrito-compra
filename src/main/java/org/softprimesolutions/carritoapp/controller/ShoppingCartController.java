package org.softprimesolutions.carritoapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.softprimesolutions.carritoapp.domain.Client;
import org.softprimesolutions.carritoapp.domain.Product;
import org.softprimesolutions.carritoapp.domain.ShoppingCart;
import org.softprimesolutions.carritoapp.domain.ShoppingCartDetail;
import org.softprimesolutions.carritoapp.service.ClientService;
import org.softprimesolutions.carritoapp.service.ProductService;
import org.softprimesolutions.carritoapp.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    private List<ShoppingCartDetail> details = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @PostMapping("/cart/add")
    public String addCart(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity, HttpSession session) {
        Product product = productService.findById(id);
        ShoppingCartDetail detail = new ShoppingCartDetail();
        detail.setProduct(product);
        detail.setQuantity(quantity);
        detail.setPrice(product.getPrice());
        details.add(detail);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        double total = 0;
        for (ShoppingCartDetail detail : details) {
            total += detail.getPrice() * detail.getQuantity();
        }
        model.addAttribute("details", details);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/cart/save")
    public String saveCart(HttpSession session) {
        Date date = new Date();
        Client client = clientService.findById(1); // Assuming client with id 1 exists
        shoppingCart.setDate(date);
        shoppingCart.setClient(client);
        shoppingCart.setDetails(details);
        shoppingCartService.save(shoppingCart);
        for (ShoppingCartDetail detail : details) {
            detail.setShoppingCart(shoppingCart);
        }
        details.clear();
        return "checkout";
    }

    @PostMapping("/checkout/process")
    public String processPayment(@RequestParam String contactName, @RequestParam String creditCard, Model model) {



        model.addAttribute("message", "¡Pedido creado con éxito!");
        return "success"; // Redirige a la vista 'success.html'
    }
}
