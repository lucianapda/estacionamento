package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the vaga_valor database table.
 * 
 */
@Entity
@Table(name="vaga_valor")
@NamedQuery(name="VagaValor.findAll", query="SELECT v FROM VagaValor v")
public class VagaValor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private BigDecimal valor;
	private List<Vaga> vagas;
	private Estacionamento estacionamento;

	public VagaValor() {
	}


	@Id
	@Column(name="codigo_vgv")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_vgv")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(name="valor_vgv")
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="vagaValor")
	public List<Vaga> getVagas() {
		return this.vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Vaga addVaga(Vaga vaga) {
		getVagas().add(vaga);
		vaga.setVagaValor(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVagas().remove(vaga);
		vaga.setVagaValor(null);

		return vaga;
	}


	//bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumn(name="codest_vgv")
	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}