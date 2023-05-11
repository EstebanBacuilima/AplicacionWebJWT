package com.proyecto.react.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    private String username;

    private String password;

    private String fotoUsuario;

    private Boolean estadoUsuario;

    public Usuario() {
    }

    public Usuario(String username, String password, String fotoUsuario, Boolean estadoUsuario, Persona persona) {
        this.username = username;
        this.password = password;
        this.fotoUsuario = fotoUsuario;
        this.estadoUsuario = estadoUsuario;
        this.persona = persona;
    }

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;

    //RELACION DE MUCHOS A MUCHOS

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> roles;

}
