package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_pagamento database table.
 * 
 */
@Entity
@Table(name="forma_pagamento")
@NamedQuery(name="FormaPagamento.findAll", query="SELECT f FROM FormaPagamento f")
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private List<Transacao> transacao;

	public FormaPagamento() {
	}


	@Id
	@Column(name="codigo_fpg")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_fpg")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Transacao
	@OneToMany(mappedBy="formaPagamento")
	public List<Transacao> getTransacao() {
		return this.transacao;
	}

	public void setTransacao(List<Transacao> transacao) {
		this.transacao = transacao;
	}

	public Transacao addTransacao(Transacao transacao) {
		getTransacao().add(transacao);
		transacao.setFormaPagamento(this);

		return transacao;
	}

	public Transacao removeTransacao(Transacao transacao) {
		getTransacao().remove(transacao);
		transacao.setFormaPagamento(null);

		return transacao;
	}

}