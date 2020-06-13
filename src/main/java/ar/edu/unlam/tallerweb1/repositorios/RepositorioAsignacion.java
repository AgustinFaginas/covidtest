package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface RepositorioAsignacion {

	Asignacion consultarAsignacionPacienteInternado(Paciente paciente);
	
	void actualizarAsignacion(Asignacion asignacion);

	Asignacion consultarAsignacionPorId(Long nro);
}
