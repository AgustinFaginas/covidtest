package ar.edu.unlam.tallerweb1.repositorios.impl;

import java.time.LocalDateTime;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioInternacion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;


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
