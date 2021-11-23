package com.ibm.grupo2.repository.usuarios;

import com.ibm.grupo2.model.seguridad.Grupo;

import org.springframework.data.repository.CrudRepository;

public interface RolesRepo extends  CrudRepository<Grupo, Integer>{
    
}
