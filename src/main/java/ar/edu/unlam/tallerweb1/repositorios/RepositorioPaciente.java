package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

import java.util.List;

public interface RepositorioPaciente {

    void registrarPaciente(Paciente paciente);
	
	Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento);

    Paciente consultarPacientePorId(Long id);

    List<Paciente> pacientes();

}
