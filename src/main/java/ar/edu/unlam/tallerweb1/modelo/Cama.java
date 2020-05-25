package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Cama {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Institucion institucion;
	
	@OneToOne
	@JoinColumn
	private Paciente pacienteActual;

	public Long getId() {
		return id;
	}
	

	public Paciente getPacienteActual() {
		return pacienteActual;
	}


	public void setPacienteActual(Paciente pacienteActual) {
		this.pacienteActual = pacienteActual;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

}
