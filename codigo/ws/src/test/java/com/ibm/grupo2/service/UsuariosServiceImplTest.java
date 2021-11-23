package com.ibm.grupo2.service;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ibm.grupo2.model.seguridad.Usuario;
import com.ibm.grupo2.repository.usuarios.UsuariosRepo;

/**
*
* @author Nora Alvarez
*/
@RunWith(MockitoJUnitRunner.class)
public class UsuariosServiceImplTest {
	
	@Mock
	UsuariosRepo usuariosRepo;
	
	@InjectMocks
	UsuariosServiceImpl usuariosServiceImpl;
	

	@Test
	public void testSave() {
		Usuario usuarioMock = new Usuario(1, "usuPrueba", "Prueba", new Date(), null, true);
		
		Assert.assertNotNull(usuarioMock);
		Assert.assertTrue(usuarioMock.getNombreUsuario() == "usuPrueba");
		
	}

}
