package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Zona;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioInstitucion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Rol;

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
    public List<Institucion> obtenerListaInstituciones() {
        return sessionFactory.getCurrentSession().createCriteria(Institucion.class)
        		.add(Restrictions.eq("rol", Rol.INSTITUCION))
                .list();
    }

    @Override
    public Institucion obtenerInstitucionPorId(Long id) {

        return (Institucion) sessionFactory.getCurrentSession().createCriteria(Institucion.class)
                .add(Restrictions.eq("id", id)).uniqueResult();

    }

    @Override
    public void actualizarInstitucion(Institucion institucion) {
        sessionFactory.getCurrentSession().update(institucion);
    }

    @Override
    public List<Institucion> listarInstitucionesPorLocalidad(Long id) {
        return sessionFactory.getCurrentSession().createCriteria(Institucion.class).add(Restrictions.eq("localidad_id", id)).list();
    }

    /*@Override
    public List<Institucion> listarInstitucionesPorZona(Zona zona) {
        return sessionFactory.getCurrentSession().createCriteria(Ins);
    }*/
}
