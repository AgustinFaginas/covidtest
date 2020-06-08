package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioInstitucion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

import java.util.List;


@Repository("repositorioInstitucion")
public class RepositorioInstitucionImpl implements RepositorioInstitucion {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioInstitucionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Institucion consultarInstitucionPorCuit(String numeroCuit) {

        return (Institucion) sessionFactory.getCurrentSession().createCriteria(Institucion.class)
                .add(Restrictions.eq("numeroDocumento", numeroCuit)).uniqueResult();
    }

    @Override
    public List<Institucion> instituciones() {
        return sessionFactory.getCurrentSession().createCriteria(Institucion.class)
                .list();
    }
}
