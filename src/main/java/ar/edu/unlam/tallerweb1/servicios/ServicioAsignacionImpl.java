package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsignacion;

@Service("servicioAsignacion")
@Transactional
public class ServicioAsignacionImpl implements ServicioAsignacion {

	@Autowired
	private RepositorioAsignacion repositorioAsignacion;


	@Override
	public Asignacion consultarAsignacionPacienteInternado(Paciente paciente) throws Exception{
		
		if(repositorioAsignacion.consultarAsignacionPacienteInternado(paciente) == null) {
			throw new Exception("El paciente no se encuentra asignado a ninguna cama");
		}
		
		return repositorioAsignacion.consultarAsignacionPacienteInternado(paciente);
	}
	
	@Override
	public void actualizarAsignacion(Asignacion asignacion) {
		
		repositorioAsignacion.actualizarAsignacion(asignacion);
	}
	
}
