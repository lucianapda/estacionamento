package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private String sigla;
	private List<Cidade> cidade;

	public Pais() {
	}


	@Id
	@Column(name="codigo_pai")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_pai")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(name="sigla_pai")
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="pais")
	public List<Cidade> getCidade() {
		return this.cidade;
	}

	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}

	public Cidade addCidade(Cidade cidade) {
		getCidade().add(cidade);
		cidade.setPais(this);

		return cidade;
	}

	public Cidade removeCidade(Cidade cidade) {
		getCidade().remove(cidade);
		cidade.setPais(null);

		return cidade;
	}

}