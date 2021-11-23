package com.ibm.grupo2.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.UnidadMedida;
import com.ibm.grupo2.service.CatalogosService;

/**
*
* @author Nora Alvarez
*/
@RunWith(SpringRunner.class)
@WebMvcTest(CatalogosREST.class)
public class CatalogosRESTTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CatalogosService productoService;

	@Test
	public void testListaCategorias() {
		Categoria cat = new Categoria(1,"Ropa",true);
		List<Categoria> listaCat= new ArrayList<Categoria>();
		listaCat.add(cat);
		
		Mockito.when(productoService.listaCategorias()).thenReturn(listaCat);
		
		try {
			String username = "john.smith";
		    String password = "Prueba.";

		    String body = "{\"nombreUsuario\":\"" + username + "\", \"pwdUsuario\":\"" + password + "\"}";
			
			MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/auth/login")
		            .content(body)
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk()).andReturn();

		    String response = result.getResponse().getContentAsString();
		    response = response.replace("{\"access_token\": \"", "");
		    String token = response.replace("\"}", "");
		    token=token.substring(30);
		    System.out.println("Token "+token);
		    
			mvc.perform(get("/cat/categorias")
					 .contentType(MediaType.APPLICATION_JSON)
					 .header("Authorization",token))
					 .andExpect(status().isOk())
					 .andExpect((ResultMatcher) jsonPath("$[0].nombreCategoria", is(cat.getNombreCategoria())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testListaUnidadMedida() {
		UnidadMedida uni = new UnidadMedida(1,"Kg",true);
		List<UnidadMedida> listaUni= new ArrayList<UnidadMedida>();
		listaUni.add(uni);
		
		Mockito.when(productoService.listaUnidaMedida()).thenReturn(listaUni);
		
		try {
			String username = "john.smith";
		    String password = "Prueba.";

		    String body = "{\"nombreUsuario\":\"" + username + "\", \"pwdUsuario\":\"" + password + "\"}";
			
			MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/auth/login")
		            .content(body)
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk()).andReturn();

		    String response = result.getResponse().getContentAsString();
		    response = response.replace("{\"access_token\": \"", "");
		    String token = response.replace("\"}", "");
		    token=token.substring(30);
		    System.out.println("Token "+token);
		    
			mvc.perform(get("/cat/unidadMedida")
					 .contentType(MediaType.APPLICATION_JSON)
					 .header("Authorization",token))
					 .andExpect(status().isOk())
					 .andExpect((ResultMatcher) jsonPath("$[0].nombreUnidadMedida", is(uni.getNombreUnidadMedida())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
