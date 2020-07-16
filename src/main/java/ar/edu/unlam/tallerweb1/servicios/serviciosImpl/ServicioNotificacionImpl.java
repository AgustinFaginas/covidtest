package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;

@Service
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {
	@Autowired
	private RepositorioNotificacion repositorioNotificacion;
	

	@Override
	public void registrarNotificacion(Notificacion notificacion) {
		
		repositorioNotificacion.registrarNotificacion(notificacion);

	}


	@Override
	public List<Notificacion> buscarNotificacionPorId(Usuario usuario) {
		// TODO Auto-generated method stub
		return repositorioNotificacion.buscarNotificacionPorId(usuario);
	}

}
