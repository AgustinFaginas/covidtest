package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Documento;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface RepositorioPaciente {
	Paciente consultarPacientePorDoc(Documento documento);

	Long consultarIdDePacientePorDoc(Documento documento);

	Boolean consultarAsignacionPaciente(Long id);

	void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso);

	Boolean guardarPaciente(Paciente paciente);

}
