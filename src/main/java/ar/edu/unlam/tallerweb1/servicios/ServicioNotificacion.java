package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Notificacion;

public interface ServicioNotificacion {
	
	public void registrarNotificacion(Notificacion notificacion);
	
	public List<Notificacion> buscarNotificacionPorId(Long id);

}
