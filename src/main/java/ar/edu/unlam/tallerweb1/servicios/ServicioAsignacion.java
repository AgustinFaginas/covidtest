package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface ServicioAsignacion {
	
	public Asignacion consultarAsignacionPacienteInternado(Paciente paciente) throws Exception;
	
	public void actualizarAsignacion(Asignacion asignacion);

	
}
