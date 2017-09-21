package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_transacao database table.
 * 
 */
@Entity
@Table(name="tipo_transacao")
@NamedQuery(name="TipoTransacao.findAll", query="SELECT t FROM TipoTransacao t")
public class TipoTransacao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private List<Transacao> transacaos;

	public TipoTransacao() {
	}


	@Id
	@Column(name="codigo_tip")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_tip")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Transacao
	@OneToMany(mappedBy="tipoTransacao")
	public List<Transacao> getTransacaos() {
		return this.transacaos;
	}

	public void setTransacaos(List<Transacao> transacaos) {
		this.transacaos = transacaos;
	}

	public Transacao addTransacao(Transacao transacao) {
		getTransacaos().add(transacao);
		transacao.setTipoTransacao(this);

		return transacao;
	}

	public Transacao removeTransacao(Transacao transacao) {
		getTransacaos().remove(transacao);
		transacao.setTipoTransacao(null);

		return transacao;
	}

}