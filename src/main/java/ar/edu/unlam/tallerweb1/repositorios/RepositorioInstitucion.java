package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

import java.util.List;


public interface RepositorioInstitucion {

    Institucion consultarInstitucionPorCuit(String numeroCuit);

    List<Institucion> obtenerListaInstituciones();

	Institucion obtenerInstitucionPorId(Long id);

}
