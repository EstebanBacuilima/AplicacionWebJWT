package com.proyecto.react.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    private String identificacion;

    private String nombres;

    private String apellidos;

    private String direccion;

    private String celular;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;
}
