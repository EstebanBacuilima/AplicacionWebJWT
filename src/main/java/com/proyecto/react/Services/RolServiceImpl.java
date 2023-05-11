package com.proyecto.react.Services;

import com.proyecto.react.Models.Rol;
import com.proyecto.react.Repositorys.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Integer> implements RolService {

    @Autowired
    RolRepository rolRespository;

    @Override
    public CrudRepository<Rol, Integer> getDao() {
        return rolRespository;
    }

    @Override
    public Rol findByNombreRol(String nombreRol) {
        return rolRespository.findByNombreRol(nombreRol);
    }
}