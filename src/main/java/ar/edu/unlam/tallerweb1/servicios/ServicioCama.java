package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface ServicioCama {

	Cama consultarCamaPorId(Long id);

	List<Cama> verCamasDisponiblesPorInstitucion(Institucion institucion);

}
