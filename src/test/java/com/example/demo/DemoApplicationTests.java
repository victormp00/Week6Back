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
import java.util.Set;

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

		List<Contacto> contactos = contactoService.getContactos();
		System.out.println(contactos);
		assertEquals(50,contactos.get(0).getId());
	}
	@Test
	public void testGetContactoById() {

		Contacto contacto = contactoService.getContactoById(50);
		assertEquals(50,contacto.getId());
	}


	@Test
	public void testGetContactosFuturos() {
		List<Contacto> contactos = contactoService.getContactoFuturo();
		assertEquals(60,contactos.get(0).getId());
	}
	//Test Oportunidad

	@Test
	public void testCrearContactos() {
		Oportunidad opor = oportunidadService.getOportunidades().get(0);
		Date ahora = new Date(System.currentTimeMillis());
		oportunidadService.crearContacto("testConctacto",opor,ahora);
		List<Contacto> contactos = oportunidadService.getContactosOportunidadId(opor.getId());
		System.out.println(contactos);
		assertEquals(3,contactos.size());
	}
	@Test
	public void testCrearOportunidad() {
		Contacto contactoParaCrear = contactoService.getContactoById(50);
		oportunidadService.crearOportunidad(contactoParaCrear,false);
		assertEquals(1,oportunidadService.getOportunidades().get(2).getContactos().size());
	}
	@Test
	public void testGetOportunidades() {

		List<Oportunidad> Opor = oportunidadService.getOportunidades();
		assertEquals(22,Opor.get(0).getId());
	}
	@Test
	public void testGetOportunidadPorUsuario() {

		List<Oportunidad> OportunidadPorUsu = oportunidadService.getOportunidadesPorUsuario();
		assertEquals(22,OportunidadPorUsu.get(0).getId());
	}
	@Test
	public void testGetContactosDeOportunidadId() {

		List<Oportunidad> OportunidadPorC = oportunidadService.getOportunidades();
		List<Contacto> conc = oportunidadService.getContactosOportunidadId(OportunidadPorC.get(0).getId());
		assertEquals(2,conc.size());
	}
	@Test
	public void testGetContactosFuturosDeOportunidadId() {

		List<Oportunidad> OportunidadPorC = oportunidadService.getOportunidades();
		List<Contacto> conc = oportunidadService.getContactosPlanesFuturosId(OportunidadPorC.get(0).getId());
		assertEquals(1,conc.size());
	}
	@Test
	public void testConvertir() {

		List<Oportunidad> Opor = oportunidadService.getOportunidades();
		oportunidadService.convertiraCLiente(Opor.get(1).getId());
		assertEquals(true,Opor.get(1).isConvertidoCliente());
	}
	@Test
	public void testGetCLientesDeOportunidad() {

		List<Oportunidad> Opor = oportunidadService.getClientes();
		assertEquals(23,Opor.get(0).getId());
	}
	@Test
	public void testgetOportunidadByID() {

		Oportunidad Opor = oportunidadService.getOportunidadByID(22);
		assertEquals(22,Opor.getId());
	}

}
