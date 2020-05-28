package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {

	Usuario consultarUsuario(Usuario usuario);

	public void registrarPaciente(Usuario usuario);

	void registrarInstitucion(Usuario usuario);

}
