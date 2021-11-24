package com.ibm.grupo2.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.UnidadMedida;
import com.ibm.grupo2.repository.producto.CategoriaRepository;
import com.ibm.grupo2.repository.producto.UnidadMedidaRepository;

/**
*
* @author Nora Alvarez
*/
@RunWith(MockitoJUnitRunner.class)
public class CatalogosServiceImplTest {
	
	@Mock
	CategoriaRepository categoriaRepositoryMock;
	
	@Mock
	UnidadMedidaRepository unidadMedidaRepositoryMock;

	@InjectMocks
	CatalogosServiceImpl subject;
	
	@Before
	public void setUp() throws Exception {
		Categoria mockCat1 = new Categoria(1, "Jabon", true);
		Categoria mockCat2 = new Categoria(2, "Verduras", true);
		Categoria mockCat3 = new Categoria(3, "Salchichoneria", true);
		List<Categoria> mockListCategorias = new ArrayList<Categoria>();
		mockListCategorias.add(mockCat1);
		mockListCategorias.add(mockCat2);
		mockListCategorias.add(mockCat3);
		
		UnidadMedida mockUnidadMedida=  new UnidadMedida(1, "Kg", true);
		UnidadMedida mockUnidadMedida2=  new UnidadMedida(2, "Pzas", true);
		UnidadMedida mockUnidadMedida3=  new UnidadMedida(3, "Mts", true);
		List<UnidadMedida> mockListaUnidadMedidas = new ArrayList<UnidadMedida>();
		mockListaUnidadMedidas.add(mockUnidadMedida);
		mockListaUnidadMedidas.add(mockUnidadMedida2);
		mockListaUnidadMedidas.add(mockUnidadMedida3);
		
		Mockito.when(categoriaRepositoryMock.findAll()).thenReturn(mockListCategorias);
		Mockito.when(unidadMedidaRepositoryMock.findAll()).thenReturn(mockListaUnidadMedidas);
		
	}

	@Test
	public void testListaCategorias() {
		List<Categoria> respuestaServicio;
		respuestaServicio=subject.listaCategorias();
		
		Assert.assertNotNull(respuestaServicio);
		Assert.assertTrue(respuestaServicio.size() == 3);
		
		
	}

	@Test
	public void testListaUnidaMedida() {
		List<UnidadMedida> respuestaServicio;
		respuestaServicio=subject.listaUnidaMedida();
		
		Assert.assertNotNull(respuestaServicio);
		Assert.assertTrue(respuestaServicio.size() == 3);
	}

}
