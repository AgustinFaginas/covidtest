package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

import java.util.List;

public interface RepositorioPaciente {

    void registrarPaciente(Paciente paciente);

    void modificarPaciente(Paciente paciente);

    Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento);

    Paciente consultarPacientePorId(Long id);

    List<Paciente> pacientes();

    List<Paciente> pacientesInfectados();

    List<Paciente> posiblesInfectados();

    List<Paciente> pacientesInternados();

    void actualizarPaciente(Paciente paciente);

	List<Paciente> pacientesInternadosPorInstitucion(Long idInstitucion);
}
