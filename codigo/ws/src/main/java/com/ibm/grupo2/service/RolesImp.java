package com.ibm.grupo2.service;

import java.util.ArrayList;
import java.util.List;

import com.ibm.grupo2.dto.seguridad.GrupoDTO;

import com.ibm.grupo2.model.seguridad.Grupo;
import com.ibm.grupo2.repository.usuarios.RolesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RolesImp implements RolesService{
    

    @Autowired
    private RolesRepo rolesRepo;
  
    @Override
    public List<GrupoDTO> getRoles(){
        List<Grupo> listabd =  (List<Grupo>) rolesRepo.findAll();
        List<GrupoDTO> resultado = new ArrayList<>();
        listabd.forEach((grupo)-> {
            resultado.add(crearGrupoDTO(grupo));
        });

        return resultado;
    }

    private GrupoDTO crearGrupoDTO(Grupo grupoBD) {
        GrupoDTO respuesta = new GrupoDTO();

        respuesta.setIdGrupo(grupoBD.getIdGrupo());
        respuesta.setNombreGrupo(grupoBD.getNombreGrupo());
        respuesta.setEstatusGrupo(grupoBD.getEstatusGrupo());
      
        return respuesta;
    }

    

}
