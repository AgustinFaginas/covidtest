package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

@Repository("repositorioAsignacion")
public class RepositorioAsignacionImpl implements RepositorioAsignacion{

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioAsignacionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Asignacion consultarAsignacionPacienteInternado(Paciente paciente) {
		
		return (Asignacion) sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
				.add(Restrictions.eq("paciente", paciente))
				.add(Restrictions.isNull("horaEgreso"))
				.uniqueResult();
	}
	
	@Override
	public void actualizarAsignacion(Asignacion asignacion) {
		
		sessionFactory.getCurrentSession().update(asignacion);		
	
	}
	
	public Asignacion consultarAsignacionPorId(Long nro) {
		
		return (Asignacion) sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
				.add(Restrictions.eq("id", nro))
				.uniqueResult();
	}

}
