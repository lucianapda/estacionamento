package br.com.estacionamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private String sigla;
	private List<Cidade> cidade;

	public Pais() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pai")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
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
	@JsonManagedReference (value="cidade-pais")
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