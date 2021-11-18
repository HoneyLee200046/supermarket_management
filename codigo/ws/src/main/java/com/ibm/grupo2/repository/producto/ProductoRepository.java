package com.ibm.grupo2.repository.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.grupo2.model.productos.Producto;

/**
*
* @author Nora Alvarez
*/
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
