package com.proyecto.react.Services;

import com.proyecto.react.Models.Persona;
import com.proyecto.react.Repositorys.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaRepository;
    }
}
