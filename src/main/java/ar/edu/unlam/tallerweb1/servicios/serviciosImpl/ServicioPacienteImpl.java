package ar.edu.unlam.tallerweb1.servicios.serviciosImpl;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPaciente;

import java.util.List;

@Service
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {

    @Autowired
    private RepositorioPaciente repositorioPaciente;

    @Override
    public void registrarPaciente(Paciente paciente) {
        repositorioPaciente.registrarPaciente(paciente);
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        repositorioPaciente.modificarPaciente(paciente);
    }

    @Override
    public Paciente consultarPacientePorDoc(String numeroDocumento, TipoDocumento tipoDocumento) {
        return repositorioPaciente.consultarPacientePorDoc(numeroDocumento, tipoDocumento);
    }

    @Override
    public List<Paciente> pacientes() {
        return repositorioPaciente.pacientes();
    }

    @Override
    public Paciente consultarPacientePorId(Long id) {
        return repositorioPaciente.consultarPacientePorId(id);
    }

    @Override
    public List<Paciente> pacientesInfectados() {
        return repositorioPaciente.pacientesInfectados();
    }

    @Override
    public List<Paciente> posiblesInfectados() {
        return repositorioPaciente.posiblesInfectados();
    }

    @Override
    public List<Paciente> pacientesInternados() {
        return repositorioPaciente.pacientesInternados();
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        repositorioPaciente.actualizarPaciente(paciente);
    }

    @Override
    public Integer establecerPrioridad(Integer cantidadEnfermedades, Boolean tieneEmbarazo, IMC categoriaIMC, Integer edad) {

        Integer prioridad = 0;

        if (tieneEmbarazo) {
            prioridad = 1;
        }

        if (edad >= 65 && cantidadEnfermedades >= 3) {
            prioridad = 5;
        }

        if (edad < 18 && categoriaIMC == IMC.NORMAL && cantidadEnfermedades == 0) {
            prioridad = 2;
        }

        if (edad < 18 && cantidadEnfermedades <= 2) {
            prioridad = 2;
        }

        if (edad < 18 && cantidadEnfermedades > 2) {
            prioridad = 3;
        }

        if (categoriaIMC != IMC.NORMAL && edad >= 65 && cantidadEnfermedades >= 3) {
            prioridad = 5;
        }

        if (edad > 18 && edad < 65 && categoriaIMC != IMC.NORMAL && cantidadEnfermedades > 2) {
            prioridad = 4;
        }

        if (edad >= 65){
            prioridad = 5;
        }

        return prioridad;
    }

}
