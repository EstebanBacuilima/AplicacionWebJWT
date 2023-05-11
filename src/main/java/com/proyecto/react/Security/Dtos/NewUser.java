package com.proyecto.react.Security.Dtos;

import com.proyecto.react.Models.Persona;
import com.proyecto.react.Models.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class NewUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String fotoUsuario;

    private Boolean estadoUsuario;

    private Persona persona;

    private List<Rol> roles;


    
}
