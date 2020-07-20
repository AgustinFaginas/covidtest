package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorTest {

    public ServicioPaciente getServicioPaciente() {
        return servicioPaciente;
    }


    public void setServicioPaciente(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }


    public void setServicioTest(ServicioTest servicioTest) {
        this.servicioTest = servicioTest;
    }

    @Autowired
    private ServicioTest servicioTest;

    @Autowired
    ServicioPaciente servicioPaciente;

    @Autowired
    private ServicioLogin servicioLogin;

    @Autowired
    private ServicioLocalidad servicioLocalidad;
    
    @Autowired
    private ServicioAtajo servicioAtajo;

    public ServicioTest getServicioTest() {
        return servicioTest;
    }

    public void setServicioLocalidad(ServicioLocalidad servicioLocalidad) {
        this.servicioLocalidad = servicioLocalidad;
    }

    public ServicioLocalidad getServicioLocalidad() {
        return servicioLocalidad;
    }

    @RequestMapping("/autoTest")
    public ModelAndView aTest(HttpServletRequest request) {

    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        return new ModelAndView("autoTest", model);

    }

    @RequestMapping(value = "/validarTest", method = RequestMethod.GET)
    public ModelAndView validarTest(
    		HttpServletRequest request,
            @RequestParam(value = "fiebre", required = false) Float fiebre,
            @RequestParam(value = "perdidaOlfato", required = false) Boolean olfato,
            @RequestParam(value = "perdidaGusto", required = false) Boolean gusto,
            @RequestParam(value = "tos", required = false) Boolean tos,
            @RequestParam(value = "perdidaRespiracion", required = false) Boolean respiracion
    ) {

    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        if (servicioTest.realizarTest(fiebre, olfato, gusto, tos, respiracion)) {


            return new ModelAndView("testPositivo", model);
        } else {
            return new ModelAndView("testNegativo", model);
        }

    }

    @RequestMapping("/testPositivo")
    public ModelAndView testPositivo(HttpServletRequest request) {
    	
    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        return new ModelAndView("testPositivo", model);

    }

    @RequestMapping("/testNegativo")
    public ModelAndView testNegativo(HttpServletRequest request) {
    	
    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        return new ModelAndView("testNegativo", model);

    }

    @RequestMapping("/enfermedades")
    public ModelAndView enfermedades(
            @RequestParam(value = "ID_PACIENTE", required = false) Long ID_PACIENTE,
            HttpServletRequest request) {
    	
    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        request.getSession().getAttribute("ID_PACIENTE");

        return new ModelAndView("enfermedades", model);
    }

    @RequestMapping(path = "/validarEnfermedades", method = RequestMethod.POST)
    public ModelAndView validarEnfermedades(
            @ModelAttribute("paciente") Usuario usuario,
            HttpServletRequest request,
            @RequestParam(value = "tieneEmbarazo", required = false) Boolean tieneEmbarazo,
            @RequestParam(value = "esFumador", required = false) Boolean esFumador,
            @RequestParam(value = "tieneDiabetes", required = false) Boolean tieneDiabetes,
            @RequestParam(value = "tieneEnfHepatica", required = false) Boolean tieneEnfHepatica,
            @RequestParam(value = "tieneEnfRespiratoria", required = false) Boolean tieneEnfRespiratoria,
            @RequestParam(value = "tieneEnfRenal", required = false) Boolean tieneEnfRenal,
            @RequestParam(value = "tieneEnfCardiologica", required = false) Boolean tieneEnfCardiologica,
            @RequestParam(value = "estatura", required = false) Float estatura,
            @RequestParam(value = "peso", required = false) Float peso
    ) {
        	
    	ModelMap model = new ModelMap();

    	if(servicioAtajo.validarPermisoAPagina(request) != null) {
    		return new ModelAndView(servicioAtajo.validarPermisoAPagina(request));
    	}
    	Rol rol = (Rol) request.getSession().getAttribute("ROL");
		if(rol != null) {
			model.put("rol", rol.name());	
		}
    	model.put("armarHeader", servicioAtajo.armarHeader(request));
    	
        Long id_paciente = (Long) request.getSession().getAttribute("ID_PACIENTE");

        Paciente paciente = servicioPaciente.consultarPacientePorId(id_paciente);

        if (tieneEmbarazo == null) {
            tieneEmbarazo = false;
        }
        if (esFumador == null) {
            esFumador = false;
        }
        if (tieneDiabetes == null) {
            tieneDiabetes = false;
        }
        if (tieneEnfHepatica == null) {
            tieneEnfHepatica = false;
        }
        if (tieneEnfRespiratoria == null) {
            tieneEnfRespiratoria = false;
        }
        if (tieneEnfRenal == null) {
            tieneEnfRenal = false;
        }
        if (tieneEnfCardiologica == null) {
            tieneEnfCardiologica = false;
        }

        Integer contador = 0;

        if (tieneEmbarazo) {
            paciente.setTieneEmbarazo(true);
        }
        if (esFumador) {
            contador++;
            paciente.setEsFumador(true);
        }
        if (tieneDiabetes) {
            contador++;
            paciente.setTieneDiabetes(true);
        }
        if (tieneEnfHepatica) {
            contador++;
            paciente.setTieneEnfHepatica(true);
        }
        if (tieneEnfRespiratoria) {
            contador++;
            paciente.setTieneEnfRespiratoria(true);
        }
        if (tieneEnfRenal) {
            contador++;
            paciente.setTieneEnfRenal(true);
        }
        if (tieneEnfCardiologica) {
            contador++;
            paciente.setTieneEnfCardiologica(true);
        }

        Float estaturaMetros = estatura / 100;

        IMC categoriaIMC = servicioTest.calcularCategoriaIMC(peso, estaturaMetros);

        Integer prioridad = servicioPaciente.establecerPrioridad(contador, tieneEmbarazo, categoriaIMC, paciente.getEdad());

        paciente.setPrioridad(prioridad);

        servicioPaciente.actualizarPaciente(paciente);

        return new ModelAndView("detalleRegistroPaciente", model);
    }

    @RequestMapping(value = "/validar-email", method = RequestMethod.POST)
    public @ResponseBody
    String validarEmail(@RequestBody String json) {
    Paciente usuario = new Paciente();
    usuario.setEmail(json);
    Usuario usuario2 = servicioLogin.consultarUsuarioporEmail(usuario);
    String mensaje = "OK";
    try {
        if (usuario2.getEmail() != null) {
            mensaje = "BAD";
            return mensaje;
        }
    } catch (NullPointerException e) {
        mensaje = "OK";
        return mensaje;
    }
    return mensaje;
    }


}
