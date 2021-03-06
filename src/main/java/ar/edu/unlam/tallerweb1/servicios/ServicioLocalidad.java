package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;

public interface ServicioLocalidad {

    public List<Localidad> obtenerLocalidades();

    public Localidad obtenerLocalidadPorNombre(String nombreLocalidad);

    public void actualizarLocalidad(Localidad localidad);

    List<Partido> obtenerPartidoPorLocalidad(Long idPartido);

    List<Institucion> listarInstitucionesPorZona(Zona zona);
}
