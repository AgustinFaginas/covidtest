package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;

@Service
@Transactional

public class ServicioCamaImpl implements ServicioCama {

    @Autowired
    private RepositorioCama repositorioCama;

    @Override
    public Cama consultarCamaPorId(Long id) {

        return repositorioCama.consultarCamaPorId(id);
    }

    @Override
    public List<Cama> verCamasDisponiblesPorInstitucion(Institucion institucion) {

        return repositorioCama.verCamasDisponiblesPorInstitucion(institucion);
    }

    @Override
    public List<Cama> camas() {
        return repositorioCama.camas();
    }

    @Override//guardar cama
    public void registrarCama(Cama cama) {
        repositorioCama.registrarCama(cama);
    }

}
