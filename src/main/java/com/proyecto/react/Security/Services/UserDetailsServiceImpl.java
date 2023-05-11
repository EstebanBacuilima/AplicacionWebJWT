package com.proyecto.react.Security.Services;

import com.proyecto.react.Models.Usuario;
import com.proyecto.react.Security.Models.UsuarioPrincipal;
import com.proyecto.react.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UsuarioService userService;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Usuario user = userService.findByUsername(userName);
        return UsuarioPrincipal.build(user);
    }
    
}
