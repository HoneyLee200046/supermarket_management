package com.ibm.grupo2.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.Producto;

/**
*
* @author Nora Alvarez
*/
public interface ProductoService {

	ResponseEntity<Producto> crearProducto(Producto nuevoProducto);
	List<Producto> listaProductos();

}
