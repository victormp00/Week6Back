package com.example.demo;


import com.example.demo.oportuService.ContactoService;
import com.example.demo.oportuService.OportunidadService;
import com.example.demo.oportuService.UsuarioService;
import com.example.demo.oprtu.Contacto;
import com.example.demo.oprtu.Oportunidad;
import com.example.demo.oprtu.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	UsuarioService usuarioService = new UsuarioService();
	ContactoService contactoService = new ContactoService();
	OportunidadService oportunidadService = new OportunidadService();

	//Test usuarios
	@Test
	public void testGetusuario() {
		List<Usuario> usuarios = UsuarioService.getUsuarios();
		assertEquals("admin",usuarios.get(0).getNombre());
	}
	@Test
	public void testLogIn() {
		Boolean Log = UsuarioService.comprobarLog("admin","admin");
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
		Oportunidad opor = null;
		Date fecha=null;
		contactoService.crearContacto(40,"testConctacto",opor,fecha);
		Contacto contacto = contactoService.getContactoById(40);
		assertEquals(40,contacto.getId());
	}
	@Test
	public void testGetContactosFuturos() {
		List<Contacto> contactos = contactoService.getContactoFuturo();
		assertEquals(2,contactos.get(0).getId());
	}
	//Test Oportunidad
	@Test
	public void testGetOportunidad() {

		List<Oportunidad> Opor = oportunidadService.getOportunidades();
		assertEquals(22,Opor.get(0).getId());
	}
	@Test
	public void testGetOportunidadPorUsuario() {

		List<Oportunidad> Opor = oportunidadService.getOportunidadesPorUsuario();
		assertEquals(22,Opor.get(0).getId());
	}
	@Test
	public void testGetContactosDeOportunidad() {

		List<Contacto> Opor = oportunidadService.getContactosOportunidad();
		assertEquals(22,Opor.get(0).getId());
	}
	@Test
	public void testConvertir() {

		List<Oportunidad> Opor = oportunidadService.getOportunidades();
		oportunidadService.convertiraCLiente(Opor.get(0));
		assertEquals(true,Opor.get(0).isConvertidoCliente());
	}
	@Test
	public void testGetCLientesDeOportunidad() {

		List<Oportunidad> Opor = oportunidadService.getClientes();
		assertEquals(23,Opor.get(0).getId());
	}

}
