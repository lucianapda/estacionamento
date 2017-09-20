package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private String placa;
	private List<EstacionamentoControle> estacionamentoControles;
	private VeiculoTipo veiculoTipo;
	private List<VeiculoUsuario> veiculoUsuarios;

	public Veiculo() {
	}


	@Id
	@Column(name="codigo_vei")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_vei")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(name="placa_vei")
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	//bi-directional many-to-one association to EstacionamentoControle
	@OneToMany(mappedBy="veiculo")
	public List<EstacionamentoControle> getEstacionamentoControles() {
		return this.estacionamentoControles;
	}

	public void setEstacionamentoControles(List<EstacionamentoControle> estacionamentoControles) {
		this.estacionamentoControles = estacionamentoControles;
	}

	public EstacionamentoControle addEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().add(estacionamentoControle);
		estacionamentoControle.setVeiculo(this);

		return estacionamentoControle;
	}

	public EstacionamentoControle removeEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().remove(estacionamentoControle);
		estacionamentoControle.setVeiculo(null);

		return estacionamentoControle;
	}


	//bi-directional many-to-one association to VeiculoTipo
	@ManyToOne
	@JoinColumn(name="codvmd_vei")
	public VeiculoTipo getVeiculoTipo() {
		return this.veiculoTipo;
	}

	public void setVeiculoTipo(VeiculoTipo veiculoTipo) {
		this.veiculoTipo = veiculoTipo;
	}


	//bi-directional many-to-one association to VeiculoUsuario
	@OneToMany(mappedBy="veiculo")
	public List<VeiculoUsuario> getVeiculoUsuarios() {
		return this.veiculoUsuarios;
	}

	public void setVeiculoUsuarios(List<VeiculoUsuario> veiculoUsuarios) {
		this.veiculoUsuarios = veiculoUsuarios;
	}

	public VeiculoUsuario addVeiculoUsuario(VeiculoUsuario veiculoUsuario) {
		getVeiculoUsuarios().add(veiculoUsuario);
		veiculoUsuario.setVeiculo(this);

		return veiculoUsuario;
	}

	public VeiculoUsuario removeVeiculoUsuario(VeiculoUsuario veiculoUsuario) {
		getVeiculoUsuarios().remove(veiculoUsuario);
		veiculoUsuario.setVeiculo(null);

		return veiculoUsuario;
	}

}