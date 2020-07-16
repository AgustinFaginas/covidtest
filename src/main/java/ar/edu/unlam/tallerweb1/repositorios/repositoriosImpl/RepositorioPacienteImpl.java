package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;

@Repository("repositorioPaciente")
@Transactional
public class RepositorioPacienteImpl implements RepositorioPaciente {
    @Inject
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPacienteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void registrarPaciente(Paciente paciente) {

        sessionFactory.getCurrentSession().save(paciente);
    }

    @Override
    public void modificarPaciente(Paciente paciente) {

        sessionFactory.getCurrentSession().saveOrUpdate(paciente);
    }

    @SuppressWarnings("deprecation")
    public Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {

        return (Paciente) sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .add(Restrictions.eq("numeroDocumento", numeroDocumento)).add(Restrictions.eq("tipoDocumento", tipoDocumento))
                .uniqueResult();
    }


    @SuppressWarnings("deprecation")
    @Override
    public Paciente consultarPacientePorId(Long id) {

        return (Paciente) sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Paciente> pacientes() {
        return sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .list();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Paciente> pacientesInfectados() {
        return sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .add(Restrictions.eq("infectado", true))
                .list();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Paciente> posiblesInfectados() {
        return sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .add(Restrictions.eq("posibleInfectado", true))
                .list();
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Paciente> pacientesInternados() {
        return sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("paciente"), "paciente"))
                .add(Restrictions.isNull("motivoEgreso"))
                .list();
    }
    
    @SuppressWarnings({"unchecked", "deprecation"})
    @Override
    public List<Paciente> pacientesInternadosPorInstitucion(Long idInstitucion) {
    	
    	List<Asignacion> asignacionesVigentes = sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
								                .add(Restrictions.isNull("motivoEgreso"))
								                .list();
    	
    	List<Paciente> pacientesInternadosPorInstitucion = new ArrayList<Paciente>();
    	
        for (Asignacion asignacion: asignacionesVigentes) { 
        	if (asignacion.getCama().getInstitucion().getId() == idInstitucion ) {
        		pacientesInternadosPorInstitucion.add(asignacion.getPaciente());
			}
		}
        return pacientesInternadosPorInstitucion;
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        sessionFactory.getCurrentSession().update(paciente);
    }

}
