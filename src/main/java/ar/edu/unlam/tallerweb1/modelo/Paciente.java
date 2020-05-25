package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Paciente extends Usuario  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean infectado;
	private Integer edad;
	private String apellido;
	
	@OneToOne
	private Paciente pacienteActual;
	
	public Paciente getPacienteActual() {
		return pacienteActual;
	}
	public void setPacienteActual(Paciente pacienteActual) {
		this.pacienteActual = pacienteActual;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getInfectado() {
		return infectado;
	}
	public void setInfectado(Boolean infectado) {
		this.infectado = infectado;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
