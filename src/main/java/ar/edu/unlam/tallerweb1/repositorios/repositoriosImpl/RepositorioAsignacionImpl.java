package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsignacion;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

import java.util.List;

@Repository("repositorioAsignacion")
public class RepositorioAsignacionImpl implements RepositorioAsignacion {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAsignacionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Asignacion consultarAsignacionPacienteInternado(Paciente paciente) {

        return (Asignacion) sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
                .add(Restrictions.eq("paciente", paciente))
                .add(Restrictions.isNull("horaEgreso"))
                .uniqueResult();
    }

    @Override
    public void actualizarAsignacion(Asignacion asignacion) {

        sessionFactory.getCurrentSession().update(asignacion);

    }

    public Asignacion consultarAsignacionPorId(Long nro) {

        return (Asignacion) sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
                .add(Restrictions.eq("id", nro))
                .uniqueResult();
    }

    /*@Override
    public List<Asignacion> obtenerAsignaciones() {
        return sessionFactory.getCurrentSession().createQuery("SELECT cama_id FROM asignacion")
                .list();
    }*/

    @Override
    public List<Asignacion> obtenerAsignacionesActuales() {
        return sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
                .add(Restrictions.isNull("motivoEgreso"))
                .list();
    }

}
