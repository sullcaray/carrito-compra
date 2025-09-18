package org.softprimesolutions.carritoapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.softprimesolutions.carritoapp.dto.request.LoginRequest;
import org.softprimesolutions.carritoapp.dto.response.LoginResponse;
import org.softprimesolutions.carritoapp.model.User;
import org.softprimesolutions.carritoapp.repository.UserRepository;
import org.softprimesolutions.carritoapp.security.JwtUtil;
import org.softprimesolutions.carritoapp.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // Autenticar al usuario
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Obtener el usuario autenticado
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Buscar el usuario en la base de datos con roles cargados para evitar LazyInitializationException
        User user = userRepository.findByUsernameWithRoles(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Generar token JWT
        String jwt = jwtUtil.generateToken(userDetails);

        // Obtener roles del usuario - ahora los roles están cargados
        List<String> roles = user.getRoles().stream()
                .map(userRol -> userRol.getRol().getName())
                .collect(Collectors.toList());

        return new LoginResponse(jwt, user.getUsername(), user.getEmail(), roles);
    }

}
