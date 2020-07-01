package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
public class ControladorCama {

    @Autowired
    ServicioCama servicioCama;

    @Autowired
    ServicioPaciente servicioPaciente;

    @Autowired
    ServicioInstitucion servicioInstitucion;

    @Autowired
    ServicioAsignacion servicioAsignacion;

    @RequestMapping("/listaCamas")
    public ModelAndView listarCamas(@RequestParam(value = "idPaciente") Long idPaciente) {

        List<Cama> camas = servicioCama.camas();

        ModelMap model = new ModelMap();

        Paciente pacienteAInternar = servicioPaciente.consultarPacientePorId(idPaciente);

        model.put("camas", camas);
        model.put("idPaciente", idPaciente);
        model.put("pacienteAInternar", pacienteAInternar);

        return new ModelAndView("listaCamas", model);
    }

    @RequestMapping("/vista-camas")
    public ModelAndView vistaCamas(@RequestParam(value = "id") Long id) {

        Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);

        Integer cantidadCamas = servicioCama.obtenerCamasPorInstitucion(institucion).size();
        List<Cama> camasTotales = servicioCama.obtenerCamasPorInstitucion(institucion);

        Integer cantidadAsignaciones = servicioAsignacion.obtenerAsignacionesActuales().size();

        List<Asignacion> asignacionesActuales = new ArrayList<Asignacion>();

        List<Cama> camasDisponibles = camasTotales;

        ModelMap model = new ModelMap();

        if (camasDisponibles.get(0).equals(camasTotales.get(0))){
            model.put("cantidadcamasDisponiblesPorInstitucion", 1);
        }else {
            model.put("cantidadcamasDisponiblesPorInstitucion", 0);
        }

        /*for (int i=0; i<cantidadCamas; i++){
            if (asignacionesActuales.get(i).getCama().getId() == camasTotales.get(i).getId()){
                camasDisponibles.remove(asignacionesActuales.get(i));
            }

        }*/

        Integer cantidadCamasDisponiblesPorInstitucion = camasDisponibles.size();


        model.put("id", id);
        model.put("cantidadCamas", cantidadCamas);
        model.put("cantidadAsignaciones", cantidadAsignaciones);



        return new ModelAndView("vistacamas", model);
    }
}
