package com.ibm.grupo2.rest;

import com.ibm.grupo2.service.SeguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.ibm.grupo2.dto.seguridad.UsuarioDTO;


@RestController
@RequestMapping("/users")
public class UsuariosREST {
    
      @Autowired
      private SeguridadService seguridadService;
      
    @GetMapping("/usuarios")
     public ResponseEntity < List<UsuarioDTO> > findAll(){
      try{
        
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        usuarios = (List<UsuarioDTO>) seguridadService.findAll();
     
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
      }
      catch(Exception exception){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
        
     }

}
