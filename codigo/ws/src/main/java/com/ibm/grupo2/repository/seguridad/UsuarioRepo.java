package com.ibm.grupo2.repository.seguridad;

import com.ibm.grupo2.model.seguridad.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Ana Olvera
 */
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
    
    @Query("SELECT a FROM Usuario a WHERE a.nombreUsuario = :username AND a.estatusUsuario = TRUE AND a.fechaBajaUsuario IS NULL")
    Usuario findUserByUsername(@Param("username")String username);

}
