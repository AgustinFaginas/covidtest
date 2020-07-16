package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.IMC;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDocumento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioPaciente {

    public void registrarPaciente(Paciente paciente);

    public void modificarPaciente(Paciente paciente);

    public Paciente consultarPacientePorDoc(String ndoc, TipoDocumento tipoDoc);

    public List<Paciente> pacientes();

    public Paciente consultarPacientePorId(Long id);

    public List<Paciente> pacientesInfectados();

    public List<Paciente> posiblesInfectados();

    public List<Paciente> pacientesInternados();

    void actualizarPaciente(Paciente paciente);

    Integer establecerPrioridad(Integer cantidadEnfermedades, Boolean tieneEmbarazo, IMC categoriaIMC, Integer edad);
    
    List<Paciente> pacientesInternadosPorInstitucion(Long idInstitucion);
}
