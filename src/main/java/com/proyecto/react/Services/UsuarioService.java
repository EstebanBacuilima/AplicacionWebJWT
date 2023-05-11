package com.proyecto.react.Services;

import com.proyecto.react.Models.Usuario;

import java.util.Optional;

public interface UsuarioService extends GenericService<Usuario,Integer>{

    Usuario findByUsername(String username);
    boolean existsByUsername(String username);
}
