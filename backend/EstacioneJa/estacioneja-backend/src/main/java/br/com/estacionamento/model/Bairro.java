package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bairro database table.
 * 
 */
@Entity
@NamedQuery(name="Bairro.findAll", query="SELECT b FROM Bairro b")
public class Bairro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private List<Localidade> localidade;

	public Bairro() {
	}


	@Id
	@Column(name="codigo_bai")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_bai")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Localidade
	@OneToMany(mappedBy="bairro")
	public List<Localidade> getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(List<Localidade> localidade) {
		this.localidade = localidade;
	}

	public Localidade addLocalidade(Localidade localidade) {
		getLocalidade().add(localidade);
		localidade.setBairro(this);

		return localidade;
	}

	public Localidade removeLocalidade(Localidade localidade) {
		getLocalidade().remove(localidade);
		localidade.setBairro(null);

		return localidade;
	}

}