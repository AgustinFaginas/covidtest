package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.TipoDeDocumento;

public interface RepositorioPaciente {
	Paciente consultarPacientePorDoc(Integer nroDocumento, TipoDeDocumento tipoDoc);

}
