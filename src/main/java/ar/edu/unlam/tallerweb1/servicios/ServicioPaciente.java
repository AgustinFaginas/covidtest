package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

import java.util.List;

public interface ServicioPaciente {

    public void registrarPaciente(Paciente paciente) throws Exception;

    public Paciente consultarPacientePorDoc(String ndoc, TipoDocumento tipoDoc);

    public Asignacion consultarAsignacionPaciente(Paciente paciente);

    public Long consultarIdAsignacionPaciente(Paciente paciente);

    public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) throws Exception;

    public Long consultarIdDePacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) throws Exception;

    public List<Paciente> pacientes();

	public Paciente ObtenerPacientePorId(Long id);

}
