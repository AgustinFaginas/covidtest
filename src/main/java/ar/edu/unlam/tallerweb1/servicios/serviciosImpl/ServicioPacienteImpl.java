package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;

import java.util.List;

@Service
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {

    @Autowired
    private RepositorioPaciente repositorioPaciente;

    @Override
    public void registrarPaciente(Paciente paciente) {
        repositorioPaciente.registrarPaciente(paciente);
    }

	@Override
	public void modificarPaciente(Paciente paciente) {
		repositorioPaciente.modificarPaciente(paciente);
	}
	
    @Override
    public Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {
        return repositorioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
    }

    @Override
    public List<Paciente> pacientes() {
        return repositorioPaciente.pacientes();
    }

    @Override
    public Paciente consultarPacientePorId(Long id) {
        return repositorioPaciente.consultarPacientePorId(id);
    }

    @Override
    public List<Paciente> pacientesInfectados() {
        return repositorioPaciente.pacientesInfectados();
    }

    @Override
    public List<Paciente> posiblesInfectados() {
        return repositorioPaciente.posiblesInfectados();
    }

	@Override
	public List<Paciente> pacientesInternados() {
		return repositorioPaciente.pacientesInternados();
	}

}
