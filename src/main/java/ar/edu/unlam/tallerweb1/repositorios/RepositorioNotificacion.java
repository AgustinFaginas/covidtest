package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;

public interface RepositorioNotificacion {

	void registrarNotificacion(Notificacion notificacion);
	
	List<Notificacion> buscarNotificacionPorId(Long id);
}
