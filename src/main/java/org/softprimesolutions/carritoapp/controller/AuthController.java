package org.softprimesolutions.carritoapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.softprimesolutions.carritoapp.dto.request.LoginRequest;
import org.softprimesolutions.carritoapp.dto.response.LoginResponse;
import org.softprimesolutions.carritoapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
