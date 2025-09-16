package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
