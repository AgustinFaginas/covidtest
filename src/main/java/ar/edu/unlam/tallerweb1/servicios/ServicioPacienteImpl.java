package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Documento;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;

@Service
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {

	@Autowired
	private RepositorioPaciente repositorioPaciente;

	@Override
	public Boolean guardarPaciente(Paciente paciente) throws Exception {

		if (repositorioPaciente.consultarPacientePorDoc(paciente.getDocumento()) != null) {
			throw new Exception("El paciente ya está registrado");

		}
		return repositorioPaciente.guardarPaciente(paciente);
	}

	@Override
	public Paciente consultarPacientePorDoc(Documento documento) {

		return repositorioPaciente.consultarPacientePorDoc(documento);
	}

	@Override
	public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) throws Exception {
		
		Long id = repositorioPaciente.consultarIdDePacientePorDoc(paciente.getDocumento());
		
		if (! repositorioPaciente.consultarAsignacionPaciente(id)) {
			throw new Exception("El paciente no está asignado");

		}

		repositorioPaciente.egresarPaciente(paciente, motivoEgreso);

	}

	@Override
	public Boolean consultarAsignacionPaciente(Paciente paciente) {
		return null;
	}

	@Override
	public Long consultarIdDePacientePorDoc(Documento documento) throws Exception {

		if (repositorioPaciente.consultarPacientePorDoc(documento) != null) {
			throw new Exception("El paciente ya está registrado");

		}
		return repositorioPaciente.consultarIdDePacientePorDoc(documento);
	}

}
