package ar.edu.unlam.tallerweb1.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.MotivoEgreso;
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

    public Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {

        return (Paciente) sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .add(Restrictions.eq("numeroDocumento", numeroDocumento)).add(Restrictions.eq("tipoDocumento", tipoDocumento))
                .uniqueResult();
    }

    @Override
    public Long consultarIdDePacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {

        return null;
    }

    @Override
    public Long consultarIdAsignacionPaciente(Paciente paciente) {

        //	return (Long) sessionFactory.getCurrentSession().createCriteria(Asignacion.class)
        //			.add(Restrictions.eq("idPaciente", paciente.getId()));
        return null;
    }

    @Override
    public List<Paciente> pacientes() {
        return sessionFactory.getCurrentSession().createCriteria(Paciente.class)
                .list();
    }

    @Override
    public void egresarPaciente(Paciente paciente, MotivoEgreso motivoEgreso) {


        Asignacion asignacionAModificar = new Asignacion();
        LocalDateTime horaDeEgreso = LocalDateTime.now();

        asignacionAModificar = consultarAsignacionPaciente(paciente);
        asignacionAModificar.setHoraEgreso(horaDeEgreso);
        asignacionAModificar.setMotivoEgreso(motivoEgreso);

        sessionFactory.getCurrentSession().saveOrUpdate(asignacionAModificar);

    }


    @Override
    public Asignacion consultarAsignacionPaciente(Paciente paciente) {
        // TODO Auto-generated method stub
        return null;
    }
}
