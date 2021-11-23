package com.ibm.grupo2.repository.seguridad;

import com.ibm.grupo2.model.seguridad.UsuarioDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Ana Olvera
 */
public interface UsuarioDetalleRepo extends PagingAndSortingRepository<UsuarioDetalle, Integer> {
    
    @Query("SELECT a FROM UsuarioDetalle a WHERE a.correoUsuarioDetalle = :correo")
    UsuarioDetalle findUsuario(@Param("correo")String username);
    
}
