package com.proyecto.react.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @Column(name = "estado_rol_activo")
    private Boolean estadoRolActivo;

}
