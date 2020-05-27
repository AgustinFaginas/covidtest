package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

@Repository
@Transactional
public class InstitucionDaoOImpl implements InstitucionDao {

	@Autowired
	SessionFactory sesion;

	@Override
	public Long guardarInstitucion(Institucion institucion) {

		return (Long) sesion.getCurrentSession().save(institucion);
	}

	@Override
	public Institucion consultarInstitucionPorId(Long id) {
		
		return sesion.getCurrentSession().get(Institucion.class, id);
	}

}
