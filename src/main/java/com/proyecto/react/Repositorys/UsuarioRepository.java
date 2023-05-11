package com.proyecto.react.Repositorys;

import com.proyecto.react.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername(String username);
    boolean existsByUsername(String username);

}
