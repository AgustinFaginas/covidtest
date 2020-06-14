package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Institucion;
import ar.edu.unlam.tallerweb1.modelo.Localidad;
import ar.edu.unlam.tallerweb1.modelo.NombreLocalidad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCama;
import ar.edu.unlam.tallerweb1.servicios.ServicioInstitucion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;


@Controller
public class ControladorInstituciones {

    @Autowired
    private ServicioInstitucion servicioInstitucion;

    @Autowired
    private ServicioCama servicioCama;
  
    @Autowired
    private ServicioPaciente servicioPaciente;

    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public ModelAndView detalle(@RequestParam(value = "nombre", required = false) String nombre) {
        String message = "Detalle de: " + nombre;

        ModelMap model = new ModelMap();

        model.put("msg", message);
        return new ModelAndView("vistaDetalle", model);


    }

    //Requiere Id
    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public ModelAndView irApanel(@RequestParam(value = "id", required = false) Long id) {


        Institucion i = new Institucion();
        i = (Institucion) servicioInstitucion.obtenerInstitucionPorId(id);
        String nombre = i.getNombre();
        Integer camas = i.getCantidadCamas();
        //String localidad = i.getDomicilio().getLocalidad().getNombreLocalidad().toString();


        String m0 = "Nombre: " + nombre;
        String m1 = "Camas disponibles: " + camas;
        //String m2 = "Localidad: " + localidad;
        ModelMap model = new ModelMap();

        model.put("m0", m0);
        model.put("m1", m1);
        //model.put("m2", m2);


        return new ModelAndView("panelInstitucion", model);


    }
    
 // Para acceder al panel de asignacion desde "pacientes" Accede al Paciente elegido.
 	@RequestMapping(value = "/Camas/{id}", method = RequestMethod.GET)
 	public String irAasignacion(Model model, @PathVariable Long id) {

 		
 		model.addAttribute("paciente", servicioPaciente.ObtenerPacientePorId(id));

 		return "AsignacionCama";
 	}


    @RequestMapping("/registroinstitucion")
    public ModelAndView registrarPaciente(

            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "cuit", required = false) String cuit,
            @RequestParam(value = "cantidadCamas", required = false) Integer camasTotales

    ) {
        Institucion institucion = new Institucion();

        institucion.setNombre(nombre);
        institucion.setEmail(email);
        institucion.setPassword(password);
        institucion.setCantidadCamas(camasTotales);
        institucion.setNumeroDocumento(cuit);
        List<Cama> camas = new ArrayList<Cama>();
        //camasTotales = camas.size();

        camasTotales = (int) camasTotales;

        try {
            servicioInstitucion.registrarInstitucion(institucion);

        } catch (Exception e) {

            e.printStackTrace();
        }

        //Crea la cantidad de camas que se indico por parametro
        for (Integer i = 0; i < camasTotales; i++) {

            Cama cama = new Cama();
            cama.setInstitucion(institucion);
            servicioCama.registrarCama(cama);

            /*if (i == 0) {
                Cama cama0 = new Cama();
                cama0.setInstitucion(institucion);
                servicioCama.registrarCama(cama0);
            }

            if (i == 1) {
                Cama cama1 = new Cama();
                cama1.setInstitucion(institucion);
                servicioCama.registrarCama(cama1);
            }

            if (i == 2) {
                Cama cama2 = new Cama();
                cama2.setInstitucion(institucion);
                servicioCama.registrarCama(cama2);
            }*/

        }


          /*Cama cama = new Cama();
            cama.setInstitucion(institucion);
            servicioCama.registrarCama(cama);
            cama.setDescripcion(String.valueOf(i));*/
        /*Cama cama1 = new Cama();
        cama1.setInstitucion(institucion);
        servicioCama.registrarCama(cama1);

        Cama cama2 = new Cama();
        cama2.setInstitucion(institucion);
        servicioCama.registrarCama(cama2);*/

        String message = "Nombre: " + nombre;
        String message2 = "Email: " + email;

        ModelMap model = new ModelMap();
        model.put("msg", message);
        model.put("msg2", message2);

        return new ModelAndView("registroinstitucion", model);
    }

    @RequestMapping("/instituciones")
    public ModelAndView instituciones() {

        List<Institucion> instituciones = servicioInstitucion.institucion();

        ModelMap model = new ModelMap();

        model.put("instituciones", instituciones);

        return new ModelAndView("instituciones", model);
    }


}
