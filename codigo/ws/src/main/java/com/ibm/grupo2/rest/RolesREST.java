package com.ibm.grupo2.rest;

import java.util.ArrayList;
import java.util.List;


import com.ibm.grupo2.service.RolesService;
import com.ibm.grupo2.dto.seguridad.GrupoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolesREST {

    @Autowired
    private RolesService rolesService;

    @GetMapping("/roles")
      public ResponseEntity<List<GrupoDTO>> getRoles() {
        try {
          List<GrupoDTO> roles = new ArrayList<GrupoDTO>();
          roles = (List<GrupoDTO>) rolesService.getRoles();          
         
          return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
     }

    
}
