package org.softprimesolutions.carritoapp.service;


import org.softprimesolutions.carritoapp.dto.request.LoginRequest;
import org.softprimesolutions.carritoapp.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
