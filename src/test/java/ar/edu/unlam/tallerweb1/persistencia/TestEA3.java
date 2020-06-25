package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;
import ar.edu.unlam.tallerweb1.servicios.serviciosImpl.ServicioPacienteImpl;
import ar.edu.unlam.tallerweb1.servicios.serviciosImpl.ServicioTestImpl;
import junit.framework.Assert;

public class TestEA3 {

	@Test
	public void TestServicio() throws Exception {
		RepositorioPaciente rpMock = mock(RepositorioPaciente.class);
		//ServicioPacienteImpl spi = mock(ServicioPacienteImpl.class);
		ServicioPacienteImpl spi = new ServicioPacienteImpl();
		Paciente paciente = mock(Paciente.class);
		String numeroDocumento = "1";
		TipoDocumento tipoDocumento = TipoDocumento.DNI;

		when(spi.getRepositorioPaciente().consultarPacientePorDoc(numeroDocumento, tipoDocumento)).thenReturn(paciente);
		when(spi.getRepositorioPaciente().consultarIdDePacientePorDoc(numeroDocumento, tipoDocumento)).thenReturn((long) 1);

		Long esperado = (long) 1;

		Assert.assertEquals(esperado, spi.consultarIdDePacientePorDoc(numeroDocumento, tipoDocumento));
	}
}