package com.proyecto.react.Repositorys;

import com.proyecto.react.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByNombreRol(String nombreRol);
}
