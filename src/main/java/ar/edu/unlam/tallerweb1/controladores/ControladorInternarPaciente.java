package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Asignacion;
import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAsignacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioInternacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorInternarPaciente {

	@Autowired
	ServicioAsignacion servicioAsignacion;
	@Autowired
	ServicioInternacion servicioInternacion;
	@Autowired
	ServicioPaciente servicioPaciente;
	@Autowired
	ServicioCama servicioCama;	
	@Autowired
	ServicioUsuario servicioUsuario;
	@Autowired
	ServicioInstitucion servicioInstitucion;

	@RequestMapping("/internarPaciente")
	public ModelAndView internarPaciente(HttpServletRequest request) {

		Long id = (long) request.getSession().getAttribute("ID");
    	Institucion institucion = servicioInstitucion.obtenerInstitucionPorId(id);
        
        List<Cama> camasTotalesInstitucion = servicioCama.obtenerCamasPorInstitucion(institucion);
        List<Asignacion> asignacionesVigentes = servicioAsignacion.obtenerAsignacionesActuales();

        LinkedList<Cama> camasDisponiblesInstitucion = new LinkedList<Cama>();
        
        for (int i = 0; i < camasTotalesInstitucion.size(); i++) {
          for (int j = 0; j < asignacionesVigentes.size(); j++) {
              if (camasTotalesInstitucion.get(i).getId() == asignacionesVigentes.get(j).getCama().getId()) {
              	camasTotalesInstitucion.get(i).setId(null);
              }
          }
        }
      
        for (int i = 0; i < camasTotalesInstitucion.size(); i++) {
          if (camasTotalesInstitucion.get(i).getId() != null) {
        	  camasDisponiblesInstitucion.add(camasTotalesInstitucion.get(i));
          }
        }
	        
	        ModelMap modelo = new ModelMap();

	        modelo.put("camas", camasDisponiblesInstitucion);
	        
		return new ModelAndView("internarPaciente", modelo);
	}
	
	@RequestMapping(path = "/detalleInternacion")
	public ModelAndView detalleInternacion(
			
			@RequestParam(value = "numeroDocumento") String numeroDocumento,
			@RequestParam(value = "tipoDocumento", required = false) TipoDocumento tipoDocumento,
			@RequestParam(value = "cama", required = false) Long idCama
			) {
		
		ModelMap model = new ModelMap();
		
		Paciente pacienteBuscado =  servicioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
		Cama camaBuscada = servicioCama.consultarCamaPorId(idCama);
		
		if (pacienteBuscado != null) {
		
			if (servicioAsignacion.consultarAsignacionPacienteInternado(pacienteBuscado) == null) {
				
				Asignacion asignacionAGuardar = new Asignacion();
				LocalDateTime horaIngreso = LocalDateTime.now();
				
				asignacionAGuardar.setPaciente(pacienteBuscado);
				asignacionAGuardar.setCama(camaBuscada);
				asignacionAGuardar.setHoraIngreso(horaIngreso );
				
				servicioInternacion.registrarInternacion(asignacionAGuardar);
				
				String mensaje = "Nombre del paciente: " + asignacionAGuardar.getPaciente().getNombre() + " " 
														 + asignacionAGuardar.getPaciente().getApellido();
				String mensaje2 = "Cama asignada: " + asignacionAGuardar.getCama().getDescripcion();
				String mensaje3 = "Hora de internación: " + asignacionAGuardar.getHoraIngreso();
				
				model.put("mensaje", mensaje);
				model.put("mensaje2", mensaje2);
				model.put("mensaje3", mensaje3);
				
				model.put("detalleInternacion", "El paciente fue egresado");

				return new ModelAndView("detalleInternacion", model);
			} 
			else {
				model.put("error", "El paciente ya está asignado");

				return new ModelAndView("redirect:/internarPaciente", model);
			}
		}	
		
		else {
			model.put("error", "No existe el paciente");
			
			return new ModelAndView("redirect:/internarPaciente", model);
		}
	}

}