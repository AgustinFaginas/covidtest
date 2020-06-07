package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Enumerated(EnumType.STRING)	
	private NombreProvincia nombreProvincia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NombreProvincia getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(NombreProvincia nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	

}
