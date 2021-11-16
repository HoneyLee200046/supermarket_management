package com.ibm.grupo2.repository.usuarios;

import org.springframework.data.repository.CrudRepository;
import com.ibm.grupo2.model.seguridad.Usuario;



public interface UsuariosRepo extends CrudRepository<Usuario, Integer> {
    
}
