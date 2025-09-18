package org.softprimesolutions.carritoapp.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.softprimesolutions.carritoapp.dto.request.LoginRequest;
import org.softprimesolutions.carritoapp.dto.response.LoginResponse;
import org.softprimesolutions.carritoapp.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final AuthService authService;

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                       @RequestParam(value = "logout", required = false) String logout,
                       Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
        }

        if (logout != null) {
            model.addAttribute("logoutMessage", "Has cerrado sesión exitosamente");
        }

        return "login";
    }

    @PostMapping("/web-login")
    public String webLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletResponse response,
                          Model model) {
        try {
            // Crear LoginRequest para reutilizar el servicio existente
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername(username);
            loginRequest.setPassword(password);

            // Autenticar y generar token JWT
            LoginResponse loginResponse = authService.login(loginRequest);

            // Almacenar el token JWT en una cookie segura
            Cookie jwtCookie = new Cookie("JWT_TOKEN", loginResponse.getToken());
            jwtCookie.setHttpOnly(true);
            jwtCookie.setSecure(false); // Cambiar a true en producción con HTTPS
            jwtCookie.setPath("/");
            jwtCookie.setMaxAge(86400); // 24 horas
            response.addCookie(jwtCookie);

            // Redirigir al dashboard
            return "redirect:/dashboard";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    @PostMapping("/web-logout")
    public String webLogout(HttpServletResponse response) {
        // Eliminar la cookie JWT
        Cookie jwtCookie = new Cookie("JWT_TOKEN", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(false);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(0); // Eliminar la cookie
        response.addCookie(jwtCookie);

        // Limpiar el contexto de seguridad
        SecurityContextHolder.clearContext();

        return "redirect:/login?logout=true";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("authorities", auth.getAuthorities());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "admin";
    }
}
