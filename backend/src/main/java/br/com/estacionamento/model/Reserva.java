package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int tempo;
	private Usuario usuario;
	private Vaga vaga;

	public Reserva() {
	}


	@Id
	@Column(name="codigo_res")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="tempo_res")
	public int getTempo() {
		return this.tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codusu_res")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to Vaga
	@ManyToOne
	@JoinColumn(name="codvag_res")
	public Vaga getVaga() {
		return this.vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}