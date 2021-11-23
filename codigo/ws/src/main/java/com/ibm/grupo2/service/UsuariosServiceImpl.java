package com.ibm.grupo2.service;


import com.ibm.grupo2.repository.usuarios.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ibm.grupo2.dto.seguridad.UsuarioDTO;
import com.ibm.grupo2.model.seguridad.Usuario;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    private UsuariosRepo usuariosRepo;
    
    public UsuariosServiceImpl(UsuariosRepo usuariosRepo) {
		this.usuariosRepo = usuariosRepo;
	}
  
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
