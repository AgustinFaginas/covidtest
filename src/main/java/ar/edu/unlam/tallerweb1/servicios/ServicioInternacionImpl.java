package ar.edu.unlam.tallerweb1.servicios;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioInternacion;

@Service
@Transactional
public class ServicioInternacionImpl implements ServicioInternacion {

	@Autowired
	private RepositorioInternacion repositorioInternacion;
	
	@Override
	public void registrarInternacion(Asignacion asignacion) {
		repositorioInternacion.registrarInternacion(asignacion);
		
	}

	
}
