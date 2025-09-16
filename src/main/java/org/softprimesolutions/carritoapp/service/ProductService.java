package org.softprimesolutions.carritoapp.service;

import java.util.List;

import org.softprimesolutions.carritoapp.domain.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
