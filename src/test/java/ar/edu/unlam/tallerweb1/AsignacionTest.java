//package ar.edu.unlam.tallerweb1;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.junit.Test;
//import org.springframework.web.servlet.ModelAndView;
//
//import ar.edu.unlam.tallerweb1.controladores.ControladorEgresarPaciente;
//import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
//import ar.edu.unlam.tallerweb1.controladores.ControladorPaciente;
//import ar.edu.unlam.tallerweb1.modelo.Asignacion;
//import ar.edu.unlam.tallerweb1.modelo.Cama;
//import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
//import ar.edu.unlam.tallerweb1.modelo.Paciente;
//import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
//
//public class AsignacionTest {
//	
//	@Test
//	public void TestNoSePuedeEgresaPacienteNuncaAsignado() {
//		
//		ServicioAsignacion servicioAsignacion = mock (ServicioAsignacion.class);
//		ServicioPaciente servicioPaciente = mock (ServicioPaciente.class);
//		
//		Paciente paciente = mock (Paciente.class);
//		ControladorPaciente controlador = new ControladorPaciente(servicioAsignacion, servicioPaciente, null, null, null);
//		HttpServletRequest request = mock(HttpServletRequest.class);
//		HttpSession session = mock (HttpSession.class);
//		MotivoEgreso motivoEgreso = MotivoEgreso.CURADO;
//		
//		when(request.getSession()).thenReturn(session);
//		when(controlador.getServicioPaciente().consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento())).thenReturn(paciente);
//		when(controlador.getServicioAsignacion().consultarAsignacionPacienteInternado(paciente)).thenReturn(null);
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("egresarPaciente");
//				
//		assertEquals(controlador.egresoValido(paciente.getNumeroDocumento(), paciente.getTipoDocumento(), motivoEgreso, request).getViewName(), model.getViewName());
//	}
//	
//	@Test
//	public void TestSePuedeEgresaPacienteAsignado() {
//		
//		ServicioAsignacion servicioAsignacion = mock (ServicioAsignacion.class);
//		ServicioPaciente servicioPaciente = mock (ServicioPaciente.class);
//		
//		Paciente paciente = mock (Paciente.class);
//		Cama cama = mock (Cama.class);
//		Asignacion asignacion = mock (Asignacion.class);
//		ControladorEgresarPaciente controlador = new ControladorEgresarPaciente(servicioAsignacion, servicioPaciente, null, null, null);
//		HttpServletRequest request = mock(HttpServletRequest.class);
//		HttpSession session = mock (HttpSession.class);
//		MotivoEgreso motivoEgreso = MotivoEgreso.CURADO;
//		
//		when(request.getSession()).thenReturn(session);
//		when(controlador.getServicioPaciente().consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento())).thenReturn(paciente);
//		when(controlador.getServicioAsignacion().consultarAsignacionPacienteInternado(paciente)).thenReturn(asignacion);
//		when(asignacion.getPaciente()).thenReturn(paciente);
//		when(asignacion.getCama()).thenReturn(cama);
//		
//		ModelAndView model = new ModelAndView();
//		
//		model.setViewName("egresoValido");
//				
//		assertEquals(controlador.egresoValido(paciente.getNumeroDocumento(), paciente.getTipoDocumento(), motivoEgreso, request).getViewName(), model.getViewName());
//		
//	}
//
//}