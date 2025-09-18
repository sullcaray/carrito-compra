package org.softprimesolutions.carritoapp.service.impl;

import org.softprimesolutions.carritoapp.model.Product;
import org.softprimesolutions.carritoapp.repository.ProductRepository;
import org.softprimesolutions.carritoapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
}
