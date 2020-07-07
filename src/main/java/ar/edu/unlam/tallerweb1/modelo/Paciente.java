package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean infectado;
    private Boolean posibleInfectado;
    private Integer edad;
    private String apellido;
    private Boolean tieneEmbarazo;
    private Boolean esFumador;
    private Boolean tieneDiabetes;
    private Boolean tieneEnfHepatica;
    private Boolean tieneEnfRespiratoria;
    private Boolean tieneEnfRenal;
    private Boolean tieneEnfCardiologica;

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

    public Boolean getPosibleInfectado() {
        return posibleInfectado;
    }

    public void setPosibleInfectado(Boolean posibleInfectado) {
        this.posibleInfectado = posibleInfectado;
    }

    public Boolean getTieneEmbarazo() {
        return tieneEmbarazo;
    }

    public void setTieneEmbarazo(Boolean tieneEmbarazo) {
        this.tieneEmbarazo = tieneEmbarazo;
    }

    public Boolean getTieneDiabetes() {
        return tieneDiabetes;
    }

    public void setTieneDiabetes(Boolean tieneDiabetes) {
        this.tieneDiabetes = tieneDiabetes;
    }

    public Boolean getTieneEnfHepatica() {
        return tieneEnfHepatica;
    }

    public void setTieneEnfHepatica(Boolean tieneEnfHepatica) {
        this.tieneEnfHepatica = tieneEnfHepatica;
    }

    public Boolean getTieneEnfRespiratoria() {
        return tieneEnfRespiratoria;
    }

    public void setTieneEnfRespiratoria(Boolean tieneEnfRespiratoria) {
        this.tieneEnfRespiratoria = tieneEnfRespiratoria;
    }

    public Boolean getTieneEnfRenal() {
        return tieneEnfRenal;
    }

    public void setTieneEnfRenal(Boolean tieneEnfRenal) {
        this.tieneEnfRenal = tieneEnfRenal;
    }

    public Boolean getTieneEnfCardiologica() {
        return tieneEnfCardiologica;
    }

    public void setTieneEnfCardiologica(Boolean tieneEnfCardiologica) {
        this.tieneEnfCardiologica = tieneEnfCardiologica;
    }

    public Boolean getEsFumador() {
        return esFumador;
    }

    public void setEsFumador(Boolean esFumador) {
        this.esFumador = esFumador;
    }
}


