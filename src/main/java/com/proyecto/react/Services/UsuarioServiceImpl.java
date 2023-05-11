package com.proyecto.react.Services;

import com.proyecto.react.Models.Usuario;
import com.proyecto.react.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
}
