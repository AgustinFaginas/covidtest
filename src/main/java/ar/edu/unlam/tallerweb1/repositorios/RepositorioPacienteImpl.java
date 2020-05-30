package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Documento;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

@Repository("repositorioPaciente")
public class RepositorioPacienteImpl implements RepositorioPaciente {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioPacienteImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public Boolean guardarPaciente(Paciente paciente) {
		
		return (Boolean) sessionFactory.getCurrentSession().save(paciente);
	
	}

	public Paciente consultarPacientePorDoc(Documento documento) {

		return (Paciente) sessionFactory.getCurrentSession().createCriteria(Paciente.class)
				.add(Restrictions.eq("numeroDeDocumeto", documento.getNumeroDocumento())).add(Restrictions.eq("tipoDocumento", documento.getTipoDocumento()))
				.uniqueResult();
	}

	@Override
	public Long consultarIdDePacientePorDoc(Documento documento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean consultarAsignacionPaciente(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) {
		// TODO Auto-generated method stub
		
	}


}
