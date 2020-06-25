package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;

public class PacienteTest {

	@Test
	public void TestFuncionaServicioConsultarIdDePacientePorDocumento() throws Exception {
		
		ServicioPaciente servicioPaciente = mock (ServicioPaciente.class);
		Paciente paciente = mock(Paciente.class);

		when(servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento())).thenReturn(paciente);
				
		assertEquals(paciente.getId(), servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()).getId());
		
	}
}
