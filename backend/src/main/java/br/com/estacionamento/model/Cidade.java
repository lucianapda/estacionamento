package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private String uf;
	private Pais pais;
	private List<Localidade> localidade;
	private List<Bairro> bairros;

	public Cidade() {
	}


	@Id
	@Column(name="codigo_cid")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigoCid) {
		this.codigo = codigoCid;
	}


	@Column(name="descri_cid")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	 @JsonManagedReference
	@OneToMany(mappedBy="cidade")
	public List<Bairro> getBairros() {
		return this.bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	@Column(name="uf_cid")
	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="codpai_cid")
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	//bi-directional many-to-one association to Localidade
	@OneToMany(mappedBy="cidade")
	public List<Localidade> getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(List<Localidade> localidade) {
		this.localidade = localidade;
	}

	public Localidade addLocalidade(Localidade localidade) {
		getLocalidade().add(localidade);
		localidade.setCidade(this);

		return localidade;
	}

	public Localidade removeLocalidade(Localidade localidade) {
		getLocalidade().remove(localidade);
		localidade.setCidade(null);

		return localidade;
	}

}