package com.example.demo;


import com.example.demo.oportuService.ContactoService;
import com.example.demo.oportuService.UsuarioService;
import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	UsuarioService usuarioService = new UsuarioService();
	ContactoService contactoService = new ContactoService();

	//Test usuarios
	@Test
	public void testGetusuario() {
		List<Usuario> usuarios = UsuarioService.getUsuarios();
		assertEquals(true,true);
	}
	@Test
	public void testLogIn() {
		Boolean Log = UsuarioService.comprobarLog("nombre","contrasena");
		assertEquals(true,Log);
	}

	//Test Contactos
	@Test
	public void testGetContactos() {

		List<Contacto> contactos = contactoService.getContacto();
		assertEquals(1,contactos.get(0).getId());
	}
	@Test
	public void testCrearContactos() {
		contactoService.CrearContacto();
		assertEquals(true,true);
	}
	@Test
	public void testGetContactosFuturos() {
		List<Contacto> contactos = contactoService.getContactoFuturo();
		assertEquals(2,contactos.get(0).getId());
	}

}
