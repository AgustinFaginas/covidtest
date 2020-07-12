package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class LoginTest {
	
	@Test
	public void TestLogeoCorecctamenteInstitucion() {
		
		ServicioLogin servicio = mock (ServicioLogin.class);
		Usuario usuario = mock (Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		ControladorLogin controlador = new ControladorLogin(servicio);
		HttpSession session = mock (HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(usuario.getRol()).thenReturn(Rol.INSTITUCION);
		when(controlador.getServicioLogin().consultarUsuario(usuario)).thenReturn(usuario);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/bienvenido");
				
		assertEquals(controlador.validarLogin(usuario, request).getViewName(), model.getViewName());
		
	}
	@Test
	public void TestLogeoCorecctamenteAdmin() {
		
		ServicioLogin servicio = mock (ServicioLogin.class);
		Usuario usuario = mock (Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		ControladorLogin controlador = new ControladorLogin(servicio);
		HttpSession session = mock (HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(usuario.getRol()).thenReturn(Rol.ADMIN);
		when(controlador.getServicioLogin().consultarUsuario(usuario)).thenReturn(usuario);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/admin");
				
		assertEquals(controlador.validarLogin(usuario, request).getViewName(), model.getViewName());
		
	}
	
	@Test
	public void TestLogeoIncorecctamente() {
		
		ServicioLogin servicio = mock (ServicioLogin.class);
		Usuario usuario = mock (Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		ControladorLogin controlador = new ControladorLogin(servicio);
		HttpSession session = mock (HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		
		when(controlador.getServicioLogin().consultarUsuario(usuario)).thenReturn(null);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
				
		assertEquals(controlador.validarLogin(usuario, request).getViewName(), model.getViewName());
		
	}
	


}