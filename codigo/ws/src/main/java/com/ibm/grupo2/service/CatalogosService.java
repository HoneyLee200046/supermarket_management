package com.ibm.grupo2.service;

import java.util.List;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.UnidadMedida;

/**
*
* @author Nora Alvarez
*/
public interface CatalogosService {

	List<Categoria> listaCategorias();
	List<UnidadMedida> listaUnidaMedida();

}
