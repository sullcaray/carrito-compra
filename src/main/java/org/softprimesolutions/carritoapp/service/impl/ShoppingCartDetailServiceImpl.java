package org.softprimesolutions.carritoapp.service.impl;

import org.softprimesolutions.carritoapp.model.ShoppingCartDetail;
import org.softprimesolutions.carritoapp.repository.ShoppingCartDetailRepository;
import org.softprimesolutions.carritoapp.service.ShoppingCartDetailService;
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
