package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDomicilio;
import ar.edu.unlam.tallerweb1.servicios.ServicioDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioDomicilioImpl implements ServicioDomicilio {

    @Autowired
    private RepositorioDomicilio repositorioDomicilio;

    @Override
    public void registrarDomicilio(Domicilio domicilio) {
        repositorioDomicilio.registrarDomicilio(domicilio);
    }

    @Override
    public void actualizarDomicilio(Domicilio domicilio) {
        repositorioDomicilio.actualizarDomicilio(domicilio);
    }

}
