package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the planos database table.
 * 
 */
@Entity
@Table(name="planos")
@NamedQuery(name="Plano.findAll", query="SELECT p FROM Plano p")
public class Plano implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private String nome;
	private BigDecimal valor;
	private List<PropagandaEstacionamento> propagandaEstacionamento;

	public Plano() {
	}


	@Id
	@Column(name="codigp_pla")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_pla")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(name="nome_pla")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to PropagandaEstacionamento
	@OneToMany(mappedBy="plano")
	public List<PropagandaEstacionamento> getPropagandaEstacionamento() {
		return this.propagandaEstacionamento;
	}

	public void setPropagandaEstacionamento(List<PropagandaEstacionamento> propagandaEstacionamento) {
		this.propagandaEstacionamento = propagandaEstacionamento;
	}

	public PropagandaEstacionamento addPropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamento().add(propagandaEstacionamento);
		propagandaEstacionamento.setPlano(this);

		return propagandaEstacionamento;
	}

	public PropagandaEstacionamento removePropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamento().remove(propagandaEstacionamento);
		propagandaEstacionamento.setPlano(null);

		return propagandaEstacionamento;
	}

}