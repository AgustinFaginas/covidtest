package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorRegistrarPaciente {

	@Autowired
	ServicioRegistro servicioRegistro;

//	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
//	public ModelAndView detalle(@RequestParam(value = "nombre", required = false) String nombre) {
//		String message = "Detalle de: " + nombre;
//
//		ModelMap model = new ModelMap();
//		
//		model.put("msg", message);
//		return new ModelAndView("vistaDetalle", model);
//	}

	
//
//	@RequestMapping(path = "/guardar-evento", method = RequestMethod.POST)
//	public ModelAndView guardarEvento(@ModelAttribute("evento") Evento evento,Long actividades[], HttpServletRequest request){
//		
//		System.out.println("\n tipo de viaje :"+evento.getTipoDeViaje());
//		ModelMap modelo = servicioEvento.validarEvento(evento);
//		Long id = (long)request.getSession().getAttribute("ID");
//		Usuario usuarioLogueado = this.servicioPerfil.mostrarPerfil(id);
//		if(modelo.size()>0){
//			List<Provincia>provincias = this.servicioProvincia.mostrarTodasLasProvincias();
//			modelo.put("evento",evento);
//			modelo.put("provincias",provincias);
//			return new ModelAndView("new-travel",modelo);
//		}else{
//			Provincia prov = this.servicioProvincia.mostrarProvincia(evento.getIdDeProvincia());
//			evento.setProvincia(prov);
//			this.servicioEvento.guardarFotoEvento(evento);
//			this.servicioEvento.guadarEvento(evento,usuarioLogueado);
//			this.servicioElemento.guardarElemetos(evento,usuarioLogueado);
//			this.servicioChat.crearChatEvento(evento,usuarioLogueado);
//			for(int i=0;i<actividades.length;i++){
//				System.out.println("\n\n actividades:"+actividades[i]);
//				this.servicioActivities.guardarActividadesEnElEvento
//				(evento,this.servicioActivities.buscarActividades(actividades[i]));
//			}
//			return new ModelAndView("redirect:/registro-evento?mensaje=exito");
//		}
//	
//	}
	
	@RequestMapping("/registroPaciente")
	public ModelAndView registrarPaciente(@RequestParam(value="nombre", required=false)String nombre,
			@RequestParam(value="apellido", required=false)String apellido) {
		
		Paciente paciente = new Paciente();
		
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		
		servicioRegistro.registrarPaciente(paciente);
		
		String message = "El nombre del paciente es: " + nombre;
		String message2 = "El apellido del paciente es: " + apellido;
		
		ModelMap model = new ModelMap();
		model.put("msg", message);
		model.put("msg2", message2);


		return new ModelAndView("registroPaciente", model);

	}

//	@RequestMapping(value = "/hi/amigo", method = RequestMethod.GET)
//	public ModelAndView helloWorld(@RequestParam(value = "firstname", required = false) String nombre,
//			@RequestParam(value = "sourcename", required = true) String apellido) {
//		String message = "El nombre ingresado es: " + nombre + "!";
//		String message2 = "El apellido ingresado es: " + apellido;
//		ModelMap model = new ModelMap();
//		model.put("msg", message);
//		model.put("msg2", message2);
//		return new ModelAndView("mensaje", model);
//	}
}
