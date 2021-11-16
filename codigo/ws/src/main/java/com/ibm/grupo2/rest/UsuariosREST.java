package com.ibm.grupo2.rest;

import com.ibm.grupo2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.ibm.grupo2.model.seguridad.Usuario;

@RestController
@RequestMapping("/users")
public class UsuariosREST {
    
      @Autowired
      private UsuariosService usuarioService;
      
    @GetMapping("/usuarios")
     public ResponseEntity < List<Usuario> > findAll(){
      try{
        
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = (List<Usuario>) usuarioService.findAll();
     
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
      }
      catch(Exception exception){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
        
     }

}
