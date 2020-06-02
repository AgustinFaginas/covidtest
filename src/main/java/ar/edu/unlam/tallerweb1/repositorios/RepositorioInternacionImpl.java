package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;

@Repository
public class RepositorioInternacionImpl implements RepositorioInternacion {
	private SessionFactory sessionFactory;


	@Autowired
	public RepositorioInternacionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void registrarInternacion(Asignacion asignacion) {
		sessionFactory.getCurrentSession().save(asignacion);
		
	}
	
	
}
