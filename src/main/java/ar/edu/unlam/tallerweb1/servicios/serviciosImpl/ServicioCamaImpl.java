package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import java.util.List;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
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

    @Autowired
    private ServicioAsignacion servicioAsignacion;

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

    @Override
    public List<Cama> ObtenerCamas() {
        // TODO Auto-generated method stub
        return repositorioCama.ObtenerCamas();
    }

    @Override
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return repositorioCama.obtenerCamasPorInstitucion(institucion);
    }

    /*@Override
    public List<Cama> obtenerCamasDisponiblesPorInstitucion(Institucion institucion) {

        List<Cama> camas = this.obtenerCamasPorInstitucion(institucion);

        List <Asignacion> asignaciones = servicioAsignacion.obtenerAsignacionesActuales();

        for (Asignacion asignacion: asignaciones) {
            for (Cama cama: camas
            ) {
                if(asignacion.getCama().getId() == cama.getId()){
                    camas.remove(cama);
                }
            }
        }

        return camas;
    }*/

}
