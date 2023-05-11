package com.proyecto.react.Services;

import com.proyecto.react.Models.Rol;

public interface RolService extends GenericService<Rol,Integer>{

    Rol findByNombreRol(String nombreRol);

}
