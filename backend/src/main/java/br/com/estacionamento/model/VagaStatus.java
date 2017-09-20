package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vaga_status database table.
 * 
 */
@Entity
@Table(name="vaga_status")
@NamedQuery(name="VagaStatus.findAll", query="SELECT v FROM VagaStatus v")
public class VagaStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private List<Vaga> vagas;

	public VagaStatus() {
	}


	@Id
	@Column(name="codigo_sta")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_sta")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="vagaStatus")
	public List<Vaga> getVagas() {
		return this.vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Vaga addVaga(Vaga vaga) {
		getVagas().add(vaga);
		vaga.setVagaStatus(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVagas().remove(vaga);
		vaga.setVagaStatus(null);

		return vaga;
	}

}