package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Override
	public Usuario consultarUsuarioPorEmail(String email) {
		
		return repositorioUsuario.consultarUsuarioPorEmail(email);
	}

	@Override
	public Usuario consultarUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorioUsuario.consultarUsuarioPorId(id);
	}



	
	
}