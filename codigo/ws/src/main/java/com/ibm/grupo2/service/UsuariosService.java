package com.ibm.grupo2.service;
import com.ibm.grupo2.model.seguridad.Usuario;

public interface UsuariosService {

    //public List<Usuario> findAll();

    public Usuario save(Usuario usuario);

    public Usuario findById(Integer id);

    
    
}
