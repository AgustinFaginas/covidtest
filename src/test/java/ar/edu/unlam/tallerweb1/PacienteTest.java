package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorInternarPaciente;
import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

public class PacienteTest {

	@Test
	public void TestFuncionaServicioConsultarIdDePacientePorDocumento() throws Exception {

		ServicioPaciente servicioPaciente = mock(ServicioPaciente.class);
		Paciente paciente = mock(Paciente.class);

		when(servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()))
				.thenReturn(paciente);

		assertEquals(paciente.getId(), servicioPaciente
				.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()).getId());

	}

	@Test

	public void TestCrearDetalleInternacionPaciente() {

		ControladorInternarPaciente c1 = new ControladorInternarPaciente();
		ServicioPaciente svPaciente = mock(ServicioPaciente.class);
		ServicioCama svCama = mock(ServicioCama.class);
		ServicioAsignacion svAsignacion = mock(ServicioAsignacion.class);
		ServicioInternacion svInternacion = mock(ServicioInternacion.class);

		TipoDocumento tipoDoc = null;
		Paciente paciente = mock(Paciente.class);
		Cama cama = mock(Cama.class);
		Long idCama = null;
		String ndoc = null;

		c1.setServicioAsignacion(svAsignacion);
		c1.setServicioCama(svCama);
		c1.setServicioPaciente(svPaciente);
		c1.setServicioInternacion(svInternacion);

		when(c1.getServicioPaciente().consultarPacientePorDoc(ndoc, tipoDoc)).thenReturn(paciente);
		when(c1.getServicioCama().consultarCamaPorId(idCama)).thenReturn(cama);
		when(c1.getServicioAsignacion().consultarAsignacionPacienteInternado(paciente)).thenReturn(null);

		ModelAndView model = new ModelAndView();
		model.setViewName("detalleInternacion");

		assertEquals(c1.detalleInternacion(ndoc, tipoDoc, idCama).getViewName(), model.getViewName());

	}

	@Test

	public void TestCrearDetalleInternacionPacienteYaExisteAsignacion() {

		ControladorInternarPaciente c1 = new ControladorInternarPaciente();
		ServicioPaciente svPaciente = mock(ServicioPaciente.class);
		ServicioCama svCama = mock(ServicioCama.class);
		ServicioAsignacion svAsignacion = mock(ServicioAsignacion.class);
		ServicioInternacion svInternacion = mock(ServicioInternacion.class);
		Asignacion asignacion = mock(Asignacion.class);

		TipoDocumento tipoDoc = null;
		Paciente paciente = mock(Paciente.class);
		Cama cama = mock(Cama.class);
		Long idCama = null;
		String ndoc = null;

		c1.setServicioAsignacion(svAsignacion);
		c1.setServicioCama(svCama);
		c1.setServicioPaciente(svPaciente);
		c1.setServicioInternacion(svInternacion);

		when(c1.getServicioPaciente().consultarPacientePorDoc(ndoc, tipoDoc)).thenReturn(paciente);
		when(c1.getServicioCama().consultarCamaPorId(idCama)).thenReturn(cama);
		when(c1.getServicioAsignacion().consultarAsignacionPacienteInternado(paciente)).thenReturn(asignacion);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/internarPaciente");

		assertEquals(c1.detalleInternacion(ndoc, tipoDoc, idCama).getViewName(), model.getViewName());

	}

	@Test

	public void TestCrearDetalleInternacionPacienteNoExistePaciente() {

		ControladorInternarPaciente c1 = new ControladorInternarPaciente();
		ServicioPaciente svPaciente = mock(ServicioPaciente.class);
		ServicioCama svCama = mock(ServicioCama.class);
		ServicioAsignacion svAsignacion = mock(ServicioAsignacion.class);
		ServicioInternacion svInternacion = mock(ServicioInternacion.class);

		TipoDocumento tipoDoc = null;
		Long idCama = null;
		String ndoc = null;

		c1.setServicioAsignacion(svAsignacion);
		c1.setServicioCama(svCama);
		c1.setServicioPaciente(svPaciente);
		c1.setServicioInternacion(svInternacion);

		when(c1.getServicioPaciente().consultarPacientePorDoc(ndoc, tipoDoc)).thenReturn(null);

		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/internarPaciente");

		assertEquals(c1.detalleInternacion(ndoc, tipoDoc, idCama).getViewName(), model.getViewName());

	}
	


}
