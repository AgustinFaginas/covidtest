package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioTestImpl implements ServicioTest {

    @Override
    public Boolean realizarTest(Float fiebre, Boolean olfato, Boolean gusto, Boolean tos, Boolean respiracion) {

        if (olfato == null) {
            olfato = false;
        }
        if (gusto == null) {
            gusto = false;
        }
        if (tos == null) {
            tos = false;
        }
        if (respiracion == null) {
            respiracion = false;
        }


        Integer contador = 0;


        if (fiebre != null) {
            if (fiebre > 37) {
                contador++;
            }
        }

        if (olfato == true) {
            contador++;
        }

        if (gusto == true) {
            contador++;
        }
        if (tos == true) {
            contador++;
        }
        if (respiracion == true) {
            contador++;
        }

        if (contador >= 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public IMC calcularCategoriaIMC(Float peso, Float estaturaMetros) {

        Float imc = peso / (estaturaMetros * estaturaMetros);

        IMC categoriaIMC = null;

        if (imc < 18.5) {
            return IMC.INFERIOR;
        }
        if (imc >= 18.5 && imc < 25.0) {
            return IMC.NORMAL;
        }
        if (imc >= 25.0 && imc < 30.0) {
            return IMC.SUPERIOR;
        }
        if (imc >= 30.0) {
            return IMC.OBESIDAD;
        }

        return categoriaIMC;
    }

	@Override
	public Boolean realizarPermiso(String nombre, String apellido, Integer edad, String tipoDocumento,
			Integer numeroDocumento, String movito) {
		
		if(edad>=18) {
			return true;
		}else {
			return false;
		}
		
		
	}


}
