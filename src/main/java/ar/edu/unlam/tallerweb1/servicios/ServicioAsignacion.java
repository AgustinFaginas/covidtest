package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

import java.util.List;

public interface ServicioAsignacion {

    public Asignacion consultarAsignacionPacienteInternado(Paciente paciente);

    public void actualizarAsignacion(Asignacion asignacion);

    public Asignacion consultarAsignacionPorId(Long nro);

    List<Asignacion> obtenerAsignacionesActuales();
}
