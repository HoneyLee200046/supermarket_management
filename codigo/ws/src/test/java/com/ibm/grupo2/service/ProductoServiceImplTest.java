package com.ibm.grupo2.service;

import java.math.BigDecimal;
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

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.Producto;
import com.ibm.grupo2.model.productos.UnidadMedida;
import com.ibm.grupo2.repository.producto.ProductoRepository;

/**
*
* @author Nora Alvarez
*/
@RunWith(MockitoJUnitRunner.class)
public class ProductoServiceImplTest {
	
	@Mock
	ProductoRepository productoRepository;
	
	@InjectMocks 
	ProductoServiceImpl subject;
	

	@Test
	public void testCrearProducto() {
		Producto productoMock= new Producto(1, "Jabon Ariel", "JND23ND", "Jabon para ropa", new BigDecimal(35), new BigDecimal(105), 
				"/img/upload/ariel.jpg", new Categoria(1,"Jabon",true), new UnidadMedida(1,"Kg",true));
		
		Assert.assertNotNull(productoMock);
		Assert.assertTrue(productoMock.getNombreProducto() == "Jabon Ariel");
	}

	@Test
	public void testListaProductos() {
		Producto productoMock= new Producto(1, "Jabon Ariel", "JND23ND", "Jabon para ropa", new BigDecimal(35), new BigDecimal(105), 
				"/img/upload/ariel.jpg", new Categoria(1,"Jabon",true), new UnidadMedida(1,"Kg",true));
		Producto productoMock2= new Producto(2, "Licuadora", "DRT23ND", "Licuadora Oster", new BigDecimal(10), new BigDecimal(850), 
				"/img/upload/licuadora.jpg", new Categoria(2,"Electrodomesticos",true), new UnidadMedida(1,"Pzas",true));
		List<Producto> mockListaProducto = new ArrayList<Producto>();
		mockListaProducto.add(productoMock);
		mockListaProducto.add(productoMock2);
		
		Mockito.when(productoRepository.findAll()).thenReturn(mockListaProducto);
		
		mockListaProducto=subject.listaProductos();
		
		Assert.assertNotNull(mockListaProducto);
		Assert.assertTrue(mockListaProducto.size() == 2);
	}

}
