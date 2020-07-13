package ar.edu.unlam.tallerweb1.repositorios.repositoriosImpl;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDomicilio;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;


@Repository("repositorioDomicilio")
@Transactional
public class RepositorioDomicilioImpl implements RepositorioDomicilio {

    @Inject
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioDomicilioImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void registrarDomicilio(Domicilio domicilio) {
        sessionFactory.getCurrentSession().save(domicilio);
    }

}
