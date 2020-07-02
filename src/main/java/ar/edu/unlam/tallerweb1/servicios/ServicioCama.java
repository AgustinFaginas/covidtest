package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface ServicioCama {

    void registrarCama(Cama cama);

    Cama consultarCamaPorId(Long id);

	List<Cama> obtenerCamas();

	List<Cama> obtenerCamasPorInstitucion(Institucion institucion);

	List<Cama> obtenerCamasDisponiblesPorInstitucion(Institucion institucion);


}
