package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Institucion;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioInstitucion {
	
	public void registrarInstitucion(Usuario usuario) throws Exception;
	public Institucion consultarInstitucionPorCuit(String numeroCuit);
	
}
