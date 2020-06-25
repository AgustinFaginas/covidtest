//package ar.edu.unlam.tallerweb1;
//import org.junit.Assert;
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.mock;
//
//import org.junit.Test;
//
//import org.junit.Test;
//import org.springframework.web.servlet.ModelAndView;
//
//import ar.edu.unlam.tallerweb1.controladores.ControladorEgresarPaciente;
//import ar.edu.unlam.tallerweb1.modelo.Asignacion;
//import ar.edu.unlam.tallerweb1.modelo.Cama;
//import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
//import ar.edu.unlam.tallerweb1.modelo.Paciente;
//import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
//
//import ar.edu.unlam.tallerweb1.controladores.ControladorTraslados;
//import ar.edu.unlam.tallerweb1.modelo.MotivoTraslado;
//import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
//import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
//
//
//public class TestTraslado {
//	
//	@Test
//	public void testQueSepuedaTrasladarDeCamaAunPacienteAsignado() {
//		
//		ServicioAsignacion servicioAsignacion = mock (ServicioAsignacion.class);
//		ServicioPaciente servicioPaciente = mock (ServicioPaciente.class);
//		ServicioCama servicioCama = mock (ServicioCama.class);
//		
//		Paciente paciente = mock (Paciente.class);
//		Cama cama = mock (Cama.class);
//		Asignacion asignacion = mock (Asignacion.class);
//		
//		ControladorTraslados controlador = new ControladorTraslados(servicioAsignacion, servicioPaciente, servicioCama);
//		cama.setId(4L);
//		Long camaId = cama.getId();
//		MotivoTraslado motivoTraslado = MotivoTraslado.TRASLADADO;
//		
//		when(controlador.getServicioPaciente().consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento())).thenReturn(paciente);
//		
//		
//		ModelAndView model = new ModelAndView();
//		
//		model.setViewName("trasladoExitoso");
//				
//		Assert.assertEquals(controlador.traslado(paciente.getNumeroDocumento(), paciente.getTipoDocumento(), asignacion.getMotivoTraslado(), cama.getId()), model);
//		
//		
//	}
//
//}
