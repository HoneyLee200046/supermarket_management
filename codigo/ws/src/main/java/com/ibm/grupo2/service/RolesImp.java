package com.ibm.grupo2.service;

import java.util.List;

import com.ibm.grupo2.model.seguridad.Grupo;
import com.ibm.grupo2.repository.usuarios.RolesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RolesImp implements RolesService{
    

    @Autowired
    private RolesRepo rolesRepo;

    @Override
    public List<Grupo> getRoles(){
        return (List<Grupo>) rolesRepo.findAll();

    }
}
