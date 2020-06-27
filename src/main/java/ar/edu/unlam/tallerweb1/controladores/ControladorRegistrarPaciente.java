package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorRegistrarPaciente {

    private ServicioInstitucion servicioInstitucion;
    private ServicioUsuario servicioUsuario;
	private ServicioPaciente servicioPaciente;
    
    @Autowired
    public ControladorRegistrarPaciente(ServicioInstitucion servicioInstitucion, ServicioCama servicioCama,
			ServicioPaciente servicioPaciente, ServicioUsuario servicioUsuario) {
		this.servicioInstitucion = servicioInstitucion;
		this.servicioUsuario = servicioUsuario;
		this.servicioPaciente = servicioPaciente;
	}
    
    @RequestMapping("/registrarPaciente")
	public ModelAndView registrarPaciente() {

		ModelMap modelo = new ModelMap();

		return new ModelAndView("registrarPaciente", modelo);
	}

	@RequestMapping("/detalleRegistroPaciente")
    public ModelAndView validarRegistroPaciente(

    		@ModelAttribute("paciente") Paciente paciente,
    		HttpServletRequest request

    ) {
        
        ModelMap model = new ModelMap();

       if(servicioUsuario.consultarUsuarioPorEmail(paciente.getEmail()) == null &&
    	  servicioPaciente.consultarPacientePorDoc(paciente.getNumeroDocumento(), paciente.getTipoDocumento()) == null) {
    	   
        servicioInstitucion.registrarInstitucion(paciente);
        
        String rol = Rol.PACIENTE.name();
        request.getSession().setAttribute(rol, paciente.getRol());

    	String mensaje = "Nombre: " + paciente.getNombre();
		String mensaje2 = "Documento: (" + paciente.getTipoDocumento() + ") " + paciente.getNumeroDocumento();
		String mensaje3 = "Email: " + paciente.getEmail();

		model.put("mensaje", mensaje);
		model.put("mensaje2", mensaje2);
		model.put("mensaje3", mensaje3);

        return new ModelAndView("detalleRegistroPaciente", model);
       }
       else {
    	   
           model.put("error", "Ya existe un usuario registrado con su mail o documento");
           
    	   return new ModelAndView("registrarPaciente", model);
       }
    }
}
