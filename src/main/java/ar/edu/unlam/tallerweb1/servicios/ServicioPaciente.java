package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Documento;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface ServicioPaciente {
	
	public Boolean guardarPaciente(Paciente paciente) throws Exception;

	public Paciente consultarPacientePorDoc(Documento documento);
	
	public Boolean consultarAsignacionPaciente(Paciente paciente);
	
	public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) throws Exception;
	
	public Long consultarIdDePacientePorDoc(Documento documento) throws Exception;
	
}
