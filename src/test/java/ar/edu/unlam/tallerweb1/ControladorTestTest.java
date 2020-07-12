package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorTest;


import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioTest;

public class ControladorTestTest {
	
	@Test
	public void TestTestPositivo() {
		
		ServicioTest servicioTest = mock (ServicioTest.class);
		ServicioPaciente servicioPaciente= mock(ServicioPaciente.class);
		
		Float fiebre=null;
		Boolean olfato=null;
		Boolean gusto=null;
		Boolean tos=null;
		Boolean respiracion=null;
		
		
		ControladorTest controladorTest = new ControladorTest();
		controladorTest.setServicioPaciente(servicioPaciente);
		controladorTest.setServicioTest(servicioTest);
		
		
		
		when(controladorTest.getServicioTest().realizarTest(fiebre, olfato, gusto, tos, respiracion)).thenReturn(true);
	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("testPositivo");
				
		assertEquals(controladorTest.validarTest(fiebre, olfato, gusto, tos, respiracion).getViewName(), model.getViewName());
	}
	
	@Test
	public void TestTestNegativo() {
		
		ServicioTest servicioTest = mock (ServicioTest.class);
		ServicioPaciente servicioPaciente= mock(ServicioPaciente.class);
		
		Float fiebre=null;
		Boolean olfato=null;
		Boolean gusto=null;
		Boolean tos=null;
		Boolean respiracion=null;
		
		
		ControladorTest controladorTest = new ControladorTest();
		
		controladorTest.setServicioPaciente(servicioPaciente);
		controladorTest.setServicioTest(servicioTest);
		
		
		
		when(controladorTest.getServicioTest().realizarTest(fiebre, olfato, gusto, tos, respiracion)).thenReturn(false);
	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("testNegativo");
				
		assertEquals(controladorTest.validarTest(fiebre, olfato, gusto, tos, respiracion).getViewName(), model.getViewName());
	}
	@Test
	public void TestValidarPermisoPositivo() {
		
		ServicioTest servicioTest = mock (ServicioTest.class);
		ServicioPaciente servicioPaciente= mock(ServicioPaciente.class);
		
		String nombre=null;
		String apellido =null;
		Integer edad=null;
		String tipoDocumento=null;
		Integer numeroDocumento=null;
		String motivo=null;
		
		
		
		ControladorTest controladorTest = new ControladorTest();
		controladorTest.setServicioPaciente(servicioPaciente);
		controladorTest.setServicioTest(servicioTest);
		
		
		when(controladorTest.getServicioTest().realizarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo)).thenReturn(true);
	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("permisoAceptado");
				
		assertEquals(controladorTest.validarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo).getViewName(), model.getViewName());
	}
	
	@Test
	public void TestValidarPermisoNegativo() {
		
		ServicioTest servicioTest = mock (ServicioTest.class);
		ServicioPaciente servicioPaciente= mock(ServicioPaciente.class);
		
		String nombre=null;
		String apellido =null;
		Integer edad=null;
		String tipoDocumento=null;
		Integer numeroDocumento=null;
		String motivo=null;
		
		
		
		ControladorTest controladorTest = new ControladorTest();
		controladorTest.setServicioPaciente(servicioPaciente);
		controladorTest.setServicioTest(servicioTest);
		
		
		
		when(controladorTest.getServicioTest().realizarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo)).thenReturn(false);
	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("permisoNegativo");
				
		assertEquals(controladorTest.validarPermiso(nombre, apellido, edad, tipoDocumento, numeroDocumento, motivo).getViewName(), model.getViewName());
	}
}
