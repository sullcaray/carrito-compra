package org.softprimesolutions.carritoapp.service;

import org.softprimesolutions.carritoapp.model.Client;
import org.softprimesolutions.carritoapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }
}
