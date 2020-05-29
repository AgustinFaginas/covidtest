package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;

@Service
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {

	@Autowired
	private RepositorioPaciente repositorioPaciente;

	@Override
	public void registrarPaciente(Paciente paciente) throws Exception {

		if (repositorioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()) != null) {
			throw new Exception("El paciente ya está registrado");

		}
		repositorioPaciente.registrarPaciente(paciente);
	}

	@Override
	public Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {

		return repositorioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
	}

	@Override
	public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) throws Exception {
		
		if (repositorioPaciente.consultarIdAsignacionPaciente(paciente) != null) {
			throw new Exception("El paciente no está asignado");

		}

		repositorioPaciente.egresarPaciente(paciente, motivoEgreso);

	}

	@Override
	public Asignacion consultarAsignacionPaciente(Paciente paciente) {
		
		return repositorioPaciente.consultarAsignacionPaciente(paciente);
	}

	@Override
	public Long consultarIdDePacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) throws Exception {

		if (repositorioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento) != null) {
			throw new Exception("El paciente ya está registrado");

		}
		return repositorioPaciente.consultarIdDePacientePorDoc(numeroDocumento, tipoDocumento);
	}

	@Override
	public Long consultarIdAsignacionPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
