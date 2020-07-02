package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Cama consultarCamaPorId(Long id) {

        return (Cama) sessionFactory.getCurrentSession().createCriteria(Cama.class).add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    //Guardar cama
    @Override
    public void registrarCama(Cama cama) {
        sessionFactory.getCurrentSession().save(cama);

    }

    @Override
    public List<Cama> obtenerCamas() {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .list();
    }

    @Override
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return sessionFactory.getCurrentSession().createCriteria(Cama.class)
                .add(Restrictions.eq("institucion", institucion))
                .list();
    }


}
