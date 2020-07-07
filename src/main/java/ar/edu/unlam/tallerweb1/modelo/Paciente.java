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
    private Boolean embarazo;
    private Boolean diabetes;
    private Boolean enfHepatica;
    private Boolean enfRespiratoria;
    private Boolean enfRenal;
    private Boolean enfCardiologica;

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

    public Boolean getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(Boolean embarazo) {
        this.embarazo = embarazo;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getEnfHepatica() {
        return enfHepatica;
    }

    public void setEnfHepatica(Boolean enfHepatica) {
        this.enfHepatica = enfHepatica;
    }

    public Boolean getEnfRespiratoria() {
        return enfRespiratoria;
    }

    public void setEnfRespiratoria(Boolean enfRespiratoria) {
        this.enfRespiratoria = enfRespiratoria;
    }

    public Boolean getEnfRenal() {
        return enfRenal;
    }

    public void setEnfRenal(Boolean enfRenal) {
        this.enfRenal = enfRenal;
    }

    public Boolean getEnfCardiologica() {
        return enfCardiologica;
    }

    public void setEnfCardiologica(Boolean enfCardiologica) {
        this.enfCardiologica = enfCardiologica;
    }
}


