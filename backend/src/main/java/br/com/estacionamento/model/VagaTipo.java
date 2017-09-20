package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vaga_tipo database table.
 * 
 */
@Entity
@Table(name="vaga_tipo")
@NamedQuery(name="VagaTipo.findAll", query="SELECT v FROM VagaTipo v")
public class VagaTipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private List<Vaga> vagas;

	public VagaTipo() {
	}


	@Id
	@Column(name="codigo_vat")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_vat")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="vagaTipo")
	public List<Vaga> getVagas() {
		return this.vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Vaga addVaga(Vaga vaga) {
		getVagas().add(vaga);
		vaga.setVagaTipo(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVagas().remove(vaga);
		vaga.setVagaTipo(null);

		return vaga;
	}

}