package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;


public interface RepositorioInstitucion {

	Institucion consultarInstitucionPorCuit(String numeroCuit);
		

}
