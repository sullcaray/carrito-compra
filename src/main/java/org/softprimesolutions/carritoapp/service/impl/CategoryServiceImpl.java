package org.softprimesolutions.carritoapp.service.impl;

import org.softprimesolutions.carritoapp.model.Category;
import org.softprimesolutions.carritoapp.repository.CategoryRepository;
import org.softprimesolutions.carritoapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
