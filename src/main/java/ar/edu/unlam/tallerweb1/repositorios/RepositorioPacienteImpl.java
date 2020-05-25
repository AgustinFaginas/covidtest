package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDocumento;

@Repository("repositorioPaciente")
public class RepositorioPacienteImpl implements RepositorioPaciente {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioPacienteImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Paciente consultarPacientePorDoc(Integer nroDocumento, TipoDeDocumento tipoDoc) {

		return (Paciente) sessionFactory.getCurrentSession().createCriteria(Paciente.class)
				.add(Restrictions.eq("numeroDeDocumeto", nroDocumento)).add(Restrictions.eq("tipoDeDocumento", tipoDoc))
				.uniqueResult();
	}

}
