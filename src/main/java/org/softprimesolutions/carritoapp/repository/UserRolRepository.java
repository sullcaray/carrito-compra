package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Long> {

}
