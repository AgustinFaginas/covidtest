package ar.edu.unlam.tallerweb1.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asignacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;


	private LocalDateTime horaEgreso;
	private LocalDateTime horaIngreso;

	@ManyToOne//(cascade= CascadeType.ALL)
	private Paciente paciente;

	@ManyToOne//(cascade= CascadeType.ALL)
	private Cama cama;
	
	@Enumerated(EnumType.STRING)
	private MotivoEgreso motivoEgreso;
	
	
	public MotivoEgreso getMotivoEgreso() {
		return motivoEgreso;
	}

	public void setMotivoEgreso(MotivoEgreso motivoEgreso) {
		this.motivoEgreso = motivoEgreso;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDateTime getHoraEgreso() {
		return horaEgreso;
	}

	public void setHoraEgreso(LocalDateTime horaEgreso) {
		this.horaEgreso = horaEgreso;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
	}

}
