package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioZona;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Repository("repositorioZona")
@Transactional
public class RepositorioZonaImpl implements RepositorioZona {

    @Inject
    SessionFactory sessionFactory;

    @Override
    public Zona obtenerZonaPorNombre(String nombreZona) {
        return (Zona) sessionFactory.getCurrentSession().createCriteria(Zona.class)
                .add(Restrictions.eq("nombre", nombreZona)).uniqueResult();
    }

   /* @Override
    public List<Zona> listarInstitucionesPorZona(Zona zona) {
        return sessionFactory.getCurrentSession().createCriteria(Zona.class)
                .add(Restrictions.eq(""))
                .list();
    }*/
}
