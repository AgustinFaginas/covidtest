package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	@Autowired
	private RepositorioUsuario servicioRegistro;

	@Override
	public void registrarPaciente(Usuario usuario) {
		if (servicioRegistro.consultarUsuario(usuario) != null) {

		}

		servicioRegistro.registrarPaciente(usuario);

	}

}
