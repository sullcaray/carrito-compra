package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
