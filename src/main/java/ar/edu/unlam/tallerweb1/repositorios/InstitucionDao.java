package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface InstitucionDao {

	Long guardarInstitucion(Institucion institucion);

	Institucion consultarInstitucionPorId(Long id);

}
