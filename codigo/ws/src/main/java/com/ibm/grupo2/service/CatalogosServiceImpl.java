package com.ibm.grupo2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.UnidadMedida;
import com.ibm.grupo2.repository.producto.CategoriaRepository;
import com.ibm.grupo2.repository.producto.UnidadMedidaRepository;

/**
*
* @author Nora Alvarez
*/
@Service
public class CatalogosServiceImpl implements CatalogosService {
	
	private CategoriaRepository categoriaRepository;
	
	private UnidadMedidaRepository unidadMedidaRepository;

	public CatalogosServiceImpl(CategoriaRepository categoriaRepository, UnidadMedidaRepository unidadMedidaRepository) {
		this.categoriaRepository = categoriaRepository;
		this.unidadMedidaRepository = unidadMedidaRepository;
	}

	@Override
	public List<Categoria> listaCategorias() {
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		categoriaRepository.findAll().forEach(listaCategorias::add);
		return listaCategorias;
	}

	@Override
	public List<UnidadMedida> listaUnidaMedida() {
		List<UnidadMedida> listaUnidadMedida = new ArrayList<UnidadMedida>();
		unidadMedidaRepository.findAll().forEach(listaUnidadMedida::add);
		return listaUnidadMedida;
	}

}
