package ar.edu.unlam.tallerweb1.modelo.listas;

import ar.edu.unlam.tallerweb1.modelo.Cama;
import ar.edu.unlam.tallerweb1.modelo.Institucion;

public class CamaInstitucion {

	private Cama cama;
	private Institucion institucion;
	private Long count;
	
	public CamaInstitucion(Cama cama, Institucion institucion) {
		this.cama = cama;
		this.institucion = institucion;
	}
	
	public CamaInstitucion(Cama cama, Institucion institucion, Long count) {
		this.cama = cama;
		this.institucion = institucion;
		this.count = count;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
