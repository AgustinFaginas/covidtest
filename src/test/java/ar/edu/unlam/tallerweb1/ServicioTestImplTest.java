package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.servicios.ServicioTest;
import ar.edu.unlam.tallerweb1.servicios.serviciosImpl.ServicioTestImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioTestImplTest {


    @Test
    public void realizarTestTest() {

        ServicioTestImpl sv1 = mock(ServicioTestImpl.class);

        Float fiebre = null;
        Boolean olfato = null;
        Boolean gusto = null;
        Boolean tos = null;
        Boolean respiracion = null;

        when(sv1.realizarTest(fiebre, olfato, gusto, tos, respiracion)).thenReturn(true);

        Boolean resultado = true;

        Assert.assertEquals(resultado, sv1.realizarTest(fiebre, olfato, gusto, tos, respiracion));


    }

    @Test
    public void testQueUnUsuarioNoIngreseDatos() {

        ServicioTest servicioTest = new ServicioTestImpl();

        Float fiebre = null;
        Boolean olfato = null;
        Boolean gusto = null;
        Boolean tos = null;
        Boolean respiracion = null;

        Boolean resultado = servicioTest.realizarTest(fiebre, olfato, gusto, tos, respiracion);

        assertThat(resultado).isFalse();

    }

}
