package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioInternacion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;

@Repository
@Transactional
public class RepositorioInternacionImpl implements RepositorioInternacion {
	@Autowired
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
