package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class TestLogin {
	
	@Test
	public void TestLogeoCorecctamente() {
		
		ServicioLogin servicio = mock (ServicioLogin.class);
		Usuario usuario = mock (Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		ControladorLogin controlador = new ControladorLogin(servicio);
		HttpSession session = mock (HttpSession.class);
		
		when(request.getSession()).thenReturn(session);
		when(controlador.getServicioLogin().consultarUsuario(usuario)).thenReturn(usuario);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/home");
				
		assertEquals(controlador.validarLogin(usuario, request).getViewName(), model.getViewName());
		
	}

}