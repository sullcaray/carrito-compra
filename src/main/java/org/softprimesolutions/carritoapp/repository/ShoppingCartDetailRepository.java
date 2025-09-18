package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.ShoppingCartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartDetailRepository extends JpaRepository<ShoppingCartDetail, Integer> {
}
