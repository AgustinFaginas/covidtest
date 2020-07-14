package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;

import java.util.List;

public interface RepositorioLocalidad {

    List<Localidad> obtenerLocalidades();

    Localidad obtenerLocalidadPorNombre(String nombreLocalidad);
}
