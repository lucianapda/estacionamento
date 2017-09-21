package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculo_usuario database table.
 * 
 */
@Entity
@Table(name="veiculo_usuario")
@NamedQuery(name="VeiculoUsuario.findAll", query="SELECT v FROM VeiculoUsuario v")
public class VeiculoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private List<EstacionamentoControle> estacionamentoControles;
	private Usuario usuario;
	private Veiculo veiculo;

	public VeiculoUsuario() {
	}


	@Id
	@Column(name="codigo_vus")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	//bi-directional many-to-one association to EstacionamentoControle
	@OneToMany(mappedBy="veiculoUsuario")
	public List<EstacionamentoControle> getEstacionamentoControles() {
		return this.estacionamentoControles;
	}

	public void setEstacionamentoControles(List<EstacionamentoControle> estacionamentoControles) {
		this.estacionamentoControles = estacionamentoControles;
	}

	public EstacionamentoControle addEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().add(estacionamentoControle);
		estacionamentoControle.setVeiculoUsuario(this);

		return estacionamentoControle;
	}

	public EstacionamentoControle removeEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().remove(estacionamentoControle);
		estacionamentoControle.setVeiculoUsuario(null);

		return estacionamentoControle;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codusu_vus")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="codvei_vus")
	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}