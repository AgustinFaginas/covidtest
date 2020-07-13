package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface ServicioTest {

    Boolean realizarTest(Float fiebre, Boolean olfato, Boolean gusto, Boolean tos, Boolean respiracion);

    IMC calcularCategoriaIMC(Float peso, Float estaturaMetros);
    
    Boolean realizarPermiso(String nombre,String apellido,Integer edad,String tipoDocumento,Integer numeroDocumento,String movito);
    
    void enviarMail (Paciente paciente);
}
