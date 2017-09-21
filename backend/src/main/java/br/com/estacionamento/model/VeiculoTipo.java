package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculo_tipo database table.
 * 
 */
@Entity
@Table(name="veiculo_tipo")
@NamedQuery(name="VeiculoTipo.findAll", query="SELECT v FROM VeiculoTipo v")
public class VeiculoTipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private List<Veiculo> veiculos;

	public VeiculoTipo() {
	}


	@Id
	@Column(name="codigo_vtp")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_vtp")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy="veiculoTipo")
	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setVeiculoTipo(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setVeiculoTipo(null);

		return veiculo;
	}

}