package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Localidad;

import java.util.List;

public interface ServicioLocalidad {

    public List<Localidad> obtenerLocalidades();

    public Localidad obtenerLocalidadPorNombre(String nombreLocalidad);

    public void actualizarLocalidad(Localidad localidad);

}
