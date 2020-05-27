package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface ServicioInstitucion {
	
	public Long guardarInstitucion(Institucion institucion) throws Exception;

	public Institucion consultarInstitucionPorId(Long id);
	
}
