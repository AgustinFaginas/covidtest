package ar.edu.unlam.tallerweb1.controladores;

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

        List<Cama> camas = servicioCama.obtenerCamas();

        ModelMap model = new ModelMap();

        Paciente pacienteAInternar = servicioPaciente.consultarPacientePorId(idPaciente);

        model.put("camas", camas);
        model.put("idPaciente", idPaciente);
        model.put("pacienteAInternar", pacienteAInternar);

        return new ModelAndView("listaCamas", model);
    }

    @RequestMapping("/vistacamas")
    public ModelAndView vistaCamas(@RequestParam(value = "id") Long id) {

        ModelMap model = new ModelMap();
    	
        Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
        
        List<Cama> camasDisponiblesPorInstitucion = servicioCama.obtenerCamasDisponiblesPorInstitucion(institucion);
        List<Cama> camasTotalesPorInstitucion = servicioCama.obtenerCamasPorInstitucion(institucion);

        model.put("id", id);
        model.put("cantidadCamas", camasTotalesPorInstitucion.size());
        model.put("cantidadCamasDisponiblesPorInstitucion", camasDisponiblesPorInstitucion.size());
        model.put("camas", camasDisponiblesPorInstitucion);

        return new ModelAndView("vistacamas", model);
       
    }
}
