package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

public interface ServicioCama {

    void registrarCama(Cama cama);

    Cama consultarCamaPorId(Long id);

    List<Cama> verCamasDisponiblesPorInstitucion(Institucion institucion);

    public List<Cama> camas();

	List<Cama> ObtenerCamas();

}
