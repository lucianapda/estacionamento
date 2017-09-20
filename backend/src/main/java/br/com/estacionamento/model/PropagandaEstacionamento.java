package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propaganda_estacionamento database table.
 * 
 */
@Entity
@Table(name="propaganda_estacionamento")
@NamedQuery(name="PropagandaEstacionamento.findAll", query="SELECT p FROM PropagandaEstacionamento p")
public class PropagandaEstacionamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Estacionamento estacionamento;
	private Plano plano;
	private Propaganda propaganda;

	public PropagandaEstacionamento() {
	}


	@Id
	@Column(name="codigo_pre")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	//bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumn(name="codest_pre")
	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}


	//bi-directional many-to-one association to Plano
	@ManyToOne
	@JoinColumn(name="codpla_pre")
	public Plano getPlano() {
		return this.plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}


	//bi-directional many-to-one association to Propaganda
	@ManyToOne
	@JoinColumn(name="codpro_pre")
	public Propaganda getPropaganda() {
		return this.propaganda;
	}

	public void setPropaganda(Propaganda propaganda) {
		this.propaganda = propaganda;
	}

}