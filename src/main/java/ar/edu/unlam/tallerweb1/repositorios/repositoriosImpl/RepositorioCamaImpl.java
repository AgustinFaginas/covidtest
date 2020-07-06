package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

@Repository("repositorioCama")
@Transactional
public class RepositorioCamaImpl implements RepositorioCama {
    
	@Inject
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCamaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("deprecation")
	@Override
    public Cama consultarCamaPorId(Long id) {
        return (Cama) sessionFactory.getCurrentSession().createCriteria(Cama.class).add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public void registrarCama(Cama cama) {
        sessionFactory.getCurrentSession().save(cama);
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamas() {
    	
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .list();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .add(Restrictions.eq("institucion", institucion))
                .list();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
    public List<Cama> obtenerCamasOcupadasPorInstitucion(Institucion institucion) {
       
            return sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
            		.setProjection(Projections.projectionList()
                	 .add(Projections.property("cama"), "cama"))
            		.add(Restrictions.isNull("motivoEgreso"))
                    .list();
    }

}
