package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion;

public interface RepositorioCama {


    Cama consultarCamaPorId(Long id);

    void registrarCama(Cama cama);

    List<Cama> obtenerCamas();

    List<Cama> obtenerCamasPorInstitucion(Institucion institucion);

	List<Cama> obtenerCamasOcupadasPorInstitucion(Institucion institucion);

	List<Cama> obtenerTotalDeCamasOcupadas();
	
	List<CamaInstitucion> obtenerCantidadDeCamasOcupadasPorInstitucion(Institucion institucion);
	
	List<CamaInstitucion> obtenerCantidadDeCamasOcupadasDeCadaInstitucion();
	
	List<CamaInstitucion> obtenerCamasPorInstitucionConSuInstitucion(Institucion institucion);
	
	List<CamaInstitucion> obtenerCamasTotalesConSuInstitucion();
	
	List<CamaInstitucion> obtenerCamasTotalesDisponiblesConSuInstitucion();
}
