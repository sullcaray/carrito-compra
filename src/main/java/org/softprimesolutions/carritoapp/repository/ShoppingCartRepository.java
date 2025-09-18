package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
