package com.ibm.grupo2.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.UnidadMedida;
import com.ibm.grupo2.service.CatalogosService;

/**
*
* @author Nora Alvarez
*/
@RestController
@RequestMapping("/cat")
public class CatalogosREST {

	@Autowired
	private CatalogosService productoService;

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> listaCategorias() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();
			categorias = (List<Categoria>) productoService.listaCategorias();
			
			if (categorias.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/unidadMedida")
	public ResponseEntity<List<UnidadMedida>> listaUnidadMedida() {
		try {
			List<UnidadMedida> unidadesMedida = new ArrayList<UnidadMedida>();
			unidadesMedida = (List<UnidadMedida>) productoService.listaUnidaMedida();
			
			if (unidadesMedida.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(unidadesMedida, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
