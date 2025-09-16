package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
