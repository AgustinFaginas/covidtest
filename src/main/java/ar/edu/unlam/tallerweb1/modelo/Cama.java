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
public class Cama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Institucion institucion;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoCama tipoCama;

    public Long getId() {
        return id;
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


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


	public TipoCama getTipoCama() {
		return tipoCama;
	}


	public void setTipoCama(TipoCama tipoCama) {
		this.tipoCama = tipoCama;
	}
}
