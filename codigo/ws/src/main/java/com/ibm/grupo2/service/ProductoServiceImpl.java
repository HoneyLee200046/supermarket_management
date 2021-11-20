package com.ibm.grupo2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.Producto;
import com.ibm.grupo2.repository.producto.ProductoRepository;

/**
*
* @author Nora Alvarez
*/
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ResponseEntity<Producto> crearProducto(Producto nuevoProducto) {
		Producto producto = productoRepository.save(nuevoProducto);
		return  new ResponseEntity<>(producto, HttpStatus.CREATED);
	}

	@Override
	public List<Producto> listaProductos() {
		List<Producto> listaProductos = new ArrayList<Producto>();
		productoRepository.findAll().forEach(listaProductos::add);
		return listaProductos;
	}
	
}
