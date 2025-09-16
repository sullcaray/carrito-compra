package org.softprimesolutions.carritoapp.repository;

import org.softprimesolutions.carritoapp.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT r FROM Rol r WHERE r.status = '1' ORDER BY r.name")
    List<Rol> findActiveRolesOrderByName();

    @Query("SELECT r FROM Rol r WHERE UPPER(r.name) LIKE UPPER(CONCAT('%', :name, '%')) AND r.status = '1'")
    List<Rol> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT COUNT(r) FROM Rol r WHERE r.status = '1'")
    long countActiveRoles();

    @Query("SELECT r FROM Rol r WHERE r.status = :status ORDER BY r.name")
    List<Rol> findByEstado(@Param("status") String status);

    @Query("SELECT r FROM Rol r WHERE r.status IN ('0', '1') ORDER BY r.name")
    List<Rol> findAllNotDeleted();
}
