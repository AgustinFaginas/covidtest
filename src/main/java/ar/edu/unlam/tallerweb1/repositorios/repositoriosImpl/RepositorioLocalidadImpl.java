package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLocalidad;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Repository("repositorioLocalidad")
@Transactional
public class RepositorioLocalidadImpl implements RepositorioLocalidad {

    @Inject
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLocalidadImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Localidad> obtenerLocalidades() {
        return sessionFactory.getCurrentSession().createCriteria(Localidad.class)
                .list();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public Localidad obtenerLocalidadPorNombre(String nombreLocalidad) {
        return (Localidad) sessionFactory.getCurrentSession().createCriteria(Localidad.class)
                .add(Restrictions.eq("nombreLocalidad", nombreLocalidad))
                .uniqueResult();
    }

    @Override
    public void actualizarLocalidad(Localidad localidad) {
        sessionFactory.getCurrentSession().update(localidad);
    }

    @Override
    public List<Partido> obtenerPartidoPorLocalidad(Long idPartido) {
        return sessionFactory.getCurrentSession().createCriteria(Localidad.class).add(Restrictions.eq("partido_id", idPartido)).list();
    }

}