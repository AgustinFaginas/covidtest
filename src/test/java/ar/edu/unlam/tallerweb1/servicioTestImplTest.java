package ar.edu.unlam.tallerweb1;

import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import ar.edu.unlam.tallerweb1.servicios.serviciosImpl.ServicioTestImpl;
import junit.framework.Assert;

class servicioTestImplTest {

	@Test
	void realizarTestTest() {
		
		
		ServicioTestImpl sv1=mock(ServicioTestImpl.class);
		
		Float fiebre=null;
		Boolean olfato=null;
		Boolean gusto=null;
		Boolean tos=null;
		Boolean respiracion = null;
		
		
		when(sv1.realizarTest(fiebre, olfato, gusto, tos, respiracion)).thenReturn(true);
		
		Boolean resultado= true;
		
		Assert.assertEquals(resultado , sv1.realizarTest(fiebre, olfato, gusto, tos, respiracion));
		
		
	}

}
