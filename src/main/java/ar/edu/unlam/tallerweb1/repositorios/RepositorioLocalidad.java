package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;

public interface RepositorioLocalidad {

    List<Localidad> obtenerLocalidades();

    Localidad obtenerLocalidadPorNombre(String nombreLocalidad);

    void actualizarLocalidad(Localidad localidad);

    List<Partido> obtenerPartidoPorLocalidad(Long idPartido);

    List<Institucion> listarInstitucionesPorZona(Zona zona);
}
