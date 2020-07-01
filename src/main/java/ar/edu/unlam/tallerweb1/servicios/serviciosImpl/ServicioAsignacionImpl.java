package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsignacion;

import java.util.List;

@Service("servicioAsignacion")
@Transactional
public class ServicioAsignacionImpl implements ServicioAsignacion {

    @Autowired
    private RepositorioAsignacion repositorioAsignacion;


    @Override
    public Asignacion consultarAsignacionPacienteInternado(Paciente paciente) {

        return repositorioAsignacion.consultarAsignacionPacienteInternado(paciente);
    }

    @Override
    public void actualizarAsignacion(Asignacion asignacion) {

        repositorioAsignacion.actualizarAsignacion(asignacion);
    }

    @Override
    public Asignacion consultarAsignacionPorId(Long nro) {

        return repositorioAsignacion.consultarAsignacionPorId(nro);
    }

    @Override
    public List<Asignacion> obtenerAsignacionesActuales() {
        return repositorioAsignacion.obtenerAsignacionesActuales();
    }


}
