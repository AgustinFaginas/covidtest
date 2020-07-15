package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;

public interface ServicioZona {
    Zona obtenerZonaPorNombre(String nombreZona);

    List<Zona> listarInstitucionesPorZona(Zona zona);
}
