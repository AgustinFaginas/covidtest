package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Enumerated(EnumType.STRING)
	private NombreLocalidad nombreLocalidad;
	
	@ManyToOne 
	@JoinColumn 
	private Partido partido;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public NombreLocalidad getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(NombreLocalidad nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	
}
