package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByIdentityDocument(String identityDocument);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByIdentityDocument(String identityDocument);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles ur LEFT JOIN FETCH ur.rol WHERE u.username = :username")
    Optional<User> findByUsernameWithRoles(@Param("username") String username);
}
