package com.portfolio.ffperezs.security.repository;


import com.portfolio.ffperezs.security.entity.Rol;
import com.portfolio.ffperezs.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
