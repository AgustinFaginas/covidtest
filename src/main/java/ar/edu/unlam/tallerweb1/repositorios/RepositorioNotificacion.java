package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioNotificacion {

	void registrarNotificacion(Notificacion notificacion);
	
	List<Notificacion> buscarNotificacionPorId(Usuario usuario);
}
