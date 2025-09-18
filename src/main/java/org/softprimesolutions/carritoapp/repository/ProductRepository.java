package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
