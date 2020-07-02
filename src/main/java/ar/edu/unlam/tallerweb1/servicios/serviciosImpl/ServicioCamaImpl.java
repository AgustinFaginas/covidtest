package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCama;

@Service
@Transactional

public class ServicioCamaImpl implements ServicioCama {

    @Autowired
    private RepositorioCama repositorioCama;

    @Autowired
    private ServicioAsignacion servicioAsignacion;

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
    public List<Cama> obtenerCamasPorInstitucion(Institucion institucion) {
        return repositorioCama.obtenerCamasPorInstitucion(institucion);
    }

	@Override
	public List<Cama> obtenerCamasDisponiblesPorInstitucion(Institucion institucion) {
//	
//		  List<Cama> camasTotalesPorInstitucion = obtenerCamasPorInstitucion(institucion);
//        LinkedList<Cama> camasTotalesPorInstitucion2 = new LinkedList<Cama>();
//        List<Asignacion> asignacionesVigentes = servicioAsignacion.obtenerAsignacionesActuales();
//
//        for (int i = 0; i < camasTotalesPorInstitucion.size(); i++) {
//            for (int j = 0; j < asignacionesVigentes.size(); j++) {
//                if (camasTotalesPorInstitucion.get(i).getId() == asignacionesVigentes.get(j).getCama().getId()) {
//                	camasTotalesPorInstitucion.get(i).setId(null);
//                }
//            }
//        }
//        
//        for (int i = 0; i < camasTotalesPorInstitucion.size(); i++) {
//            if (camasTotalesPorInstitucion.get(i).getId() != null) {
//            	camasTotalesPorInstitucion2.add(camasTotalesPorInstitucion.get(i));
//            }li
//        }
//        
//        return camasTotalesPorInstitucion2;<
//		HashSet <Cama>  todasLLAsCamas=servicioCama=(institucionID);
//		HashSet<Cama> camasAsignada=servicioAsignacion(institucion);
//		for (Cama c: camasAsignada) 
//			todas.remove(c);
//		}
//		return todas
//		
		
		
		
		
		
		
		
		  return null;
	}

}
