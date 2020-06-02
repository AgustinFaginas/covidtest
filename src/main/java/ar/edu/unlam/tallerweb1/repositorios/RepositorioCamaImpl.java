package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

@Repository("repositorioCama")
public class RepositorioCamaImpl implements RepositorioCama {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioCamaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Cama consultarCamaPorId(Long id) {

		return (Cama) sessionFactory.getCurrentSession().createCriteria(Cama.class).add(Restrictions.eq("id", id));
	}

	@Override
	public List<Cama> verCamasDisponiblesPorInstitucion(Institucion institucion) {

		return sessionFactory.getCurrentSession().createCriteria(Cama.class)
				.add(Restrictions.eq("pacienteActual", null))
				.add(Restrictions.eq("institucion", institucion.getId()))
				.list();

	}

	@Override
	public void registrarCama(Cama cama) {
		sessionFactory.getCurrentSession().save(cama);
		
	}

	
	
}
