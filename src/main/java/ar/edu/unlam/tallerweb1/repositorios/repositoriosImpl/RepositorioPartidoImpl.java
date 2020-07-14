package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPartido;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Repository("repositorioPartido")
@Transactional
public class RepositorioPartidoImpl implements RepositorioPartido {

    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public Partido obtenerPartidoPorNombre(String nombrePartido) {
        return (Partido) sessionFactory.getCurrentSession().createCriteria(Partido.class)
                .add(Restrictions.eq("nombrePartido", nombrePartido))
                .uniqueResult();
    }

}
