package org.softprimesolutions.carritoapp.service;

import org.softprimesolutions.carritoapp.model.User;

public interface UserService {
    User findByUsername(String username);
    User findById(Long id);
    User save(User user);
}
