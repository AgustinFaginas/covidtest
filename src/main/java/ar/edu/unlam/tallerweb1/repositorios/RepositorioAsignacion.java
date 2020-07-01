package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

import java.util.List;

public interface RepositorioAsignacion {

    Asignacion consultarAsignacionPacienteInternado(Paciente paciente);

    void actualizarAsignacion(Asignacion asignacion);

    Asignacion consultarAsignacionPorId(Long nro);

    List<Asignacion> obtenerAsignacionesActuales();
}
