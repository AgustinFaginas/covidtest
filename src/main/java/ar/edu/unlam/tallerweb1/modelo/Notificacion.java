package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Notificacion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String msg;
	private String asunto;
	
	@ManyToOne
    @JoinColumn
	private Usuario destinatario;
	@ManyToOne
    @JoinColumn
	private Usuario remitente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Usuario getRemitente() {
		return remitente;
	}
	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}
	
	

}
