package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.servicios.serviciosImpl.ServicioPacienteImpl;

public class PacienteTest {

	@Test
	public void TestFuncionaServicioConsultarIdDePacientePorDocumento() throws Exception {
		
		ServicioPacienteImpl servicioPacienteImpl = mock (ServicioPacienteImpl.class);
		Paciente paciente = mock(Paciente.class);

		Long esperado = (long) 0;
				
		assertEquals(esperado, servicioPacienteImpl.consultarIdDePacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()));
		
	}
}
