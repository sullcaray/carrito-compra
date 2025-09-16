package org.softprimesolutions.carritoapp.service;

import org.softprimesolutions.carritoapp.domain.ShoppingCartDetail;
import org.softprimesolutions.carritoapp.repository.ShoppingCartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartDetailServiceImpl implements ShoppingCartDetailService {

    @Autowired
    private ShoppingCartDetailRepository shoppingCartDetailRepository;

    @Override
    public ShoppingCartDetail save(ShoppingCartDetail shoppingCartDetail) {
        return shoppingCartDetailRepository.save(shoppingCartDetail);
    }
}
