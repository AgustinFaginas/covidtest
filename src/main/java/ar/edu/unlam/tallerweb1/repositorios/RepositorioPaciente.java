package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

import java.util.List;

public interface RepositorioPaciente {

    Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento);

    Long consultarIdDePacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento);

    Asignacion consultarAsignacionPaciente(Paciente paciente);

    void registrarPaciente(Paciente paciente);

    void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso);

    Long consultarIdAsignacionPaciente(Paciente paciente);

    List<Paciente> pacientes();

	Paciente ObtenerPacientePorId(Long id);

}
