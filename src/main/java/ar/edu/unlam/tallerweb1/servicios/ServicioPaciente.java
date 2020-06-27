package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

import java.util.List;

public interface ServicioPaciente {

    public void registrarPaciente(Paciente paciente);

    public Paciente consultarPacientePorDoc(String ndoc, TipoDocumento tipoDoc);

    public List<Paciente> pacientes();

    public Paciente consultarPacientePorId(Long id);

}
