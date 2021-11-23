package com.ibm.grupo2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.grupo2.model.seguridad.Usuario;
import com.ibm.grupo2.repository.seguridad.UsuarioRepo;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuarioRepo usuariosRepo;

  
    // @Override
    // public List<Usuario> findAll(){
    //     return (List<Usuario>) usuariosRepo.findAll();
    // }
  
    @Override  
    public Usuario findById(Integer id){
        return usuariosRepo.findById(id).orElse(null);
    }

     @Override  
     public Usuario save(Usuario usuario){
        return usuariosRepo.save(usuario);
    }





   
    
}
