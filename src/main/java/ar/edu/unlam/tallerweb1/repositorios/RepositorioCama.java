package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface RepositorioCama {


	Cama consultarCamaPorId(Long id);
	List<Cama> verCamasDisponiblesPorInstitucion(Institucion institucion);
	void registrarCama(Cama cama);

}
