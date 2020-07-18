package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import java.util.List;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.listas.CamaInstitucion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;

@Service
@Transactional

public class ServicioCamaImpl implements ServicioCama {

    @Autowired
    private RepositorioCama repositorioCama;

    @Override
    public Cama consultarCamaPorId(Long id) {

        return repositorioCama.consultarCamaPorId(id);
    }

    @Override
    public void registrarCama(Cama cama) {
        repositorioCama.registrarCama(cama);
    }

    @Override
    public List<Cama> obtenerCamas() {
        return repositorioCama.obtenerCamas();
    }
    
	@Override
	public List<Cama> obtenerTotalDeCamasOcupadas() {
		
		return repositorioCama.obtenerTotalDeCamasOcupadas();
	}

    @Override
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return repositorioCama.obtenerCamasPorInstitucion(institucion);
    }
    
    @Override
    public List<Cama> obtenerCamasOcupadasPorInstitucion(Institucion institucion) {
        return repositorioCama.obtenerCamasOcupadasPorInstitucion(institucion);
    }

	@Override
	public List<Cama> obtenerCamasDisponiblesPorInstitucion(Institucion institucion) {
	
    	List<Cama> camasTotalesPorInstitucion = obtenerCamasPorInstitucion(institucion);
        List<Cama> camasOcupadasPorInstitucion = obtenerCamasOcupadasPorInstitucion(institucion);
      
		for (Cama cama: camasOcupadasPorInstitucion) { 
			camasTotalesPorInstitucion.remove(cama);
		}

    	return camasTotalesPorInstitucion;

	}
	
	@Override
	public List<Cama> obtenerTotalDeCamasDisponibles() {
	
    	List<Cama> camasTotalesPorInstitucion = obtenerCamas();
        List<Cama> camasOcupadasPorInstitucion = obtenerTotalDeCamasOcupadas();
      
		for (Cama cama: camasOcupadasPorInstitucion) { 
			camasTotalesPorInstitucion.remove(cama);
		}

    	return camasTotalesPorInstitucion;

	}

	@Override
	public List<CamaInstitucion> obtenerCamasTotalesConSuInstitucion() {
		return repositorioCama.obtenerCamasTotalesConSuInstitucion();
	}

	@Override
	public List<CamaInstitucion> obtenerCamasPorInstitucionConSuInstitucion(Institucion institucion) {
		return repositorioCama.obtenerCamasPorInstitucionConSuInstitucion(institucion);
	}

	@Override
	public List<CamaInstitucion> obtenerCamasTotalesDisponiblesConSuInstitucion() {
		return repositorioCama.obtenerCamasTotalesDisponiblesConSuInstitucion();
	}

	@Override
	public List<CamaInstitucion> obtenerCantidadDeCamasOcupadasPorInstitucion(Institucion institucion) {
		return repositorioCama.obtenerCantidadDeCamasOcupadasPorInstitucion(institucion);
	}

	@Override
	public List<CamaInstitucion> obtenerCantidadDeCamasOcupadasDeCadaInstitucion() {
		return repositorioCama.obtenerCantidadDeCamasOcupadasDeCadaInstitucion();
	}

}
