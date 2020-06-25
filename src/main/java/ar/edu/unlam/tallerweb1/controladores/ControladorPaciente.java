package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorPaciente {

    @Autowired
    ServicioPaciente servicioPaciente;

    @RequestMapping("/listaPacientes")
    public ModelAndView pacientes() {

        List<Paciente> pacientes = servicioPaciente.pacientes();

        ModelMap model = new ModelMap();

        model.put("listaPacientes", pacientes);

        return new ModelAndView("listaPacientes", model);
    }
}
