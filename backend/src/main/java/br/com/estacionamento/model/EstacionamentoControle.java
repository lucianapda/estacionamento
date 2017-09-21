package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the estacionamento_controle database table.
 * 
 */
@Entity
@Table(name = "estacionamento_controle")
@NamedQuery(name = "EstacionamentoControle.findAll", query = "SELECT e FROM EstacionamentoControle e")
public class EstacionamentoControle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo_esc;
	private Date dhfim_esc;
	private Date dhini_esc;
	private boolean diaria_esc;
	private Vaga codvag_esc;
	private Veiculo codvei_esc;
	private VeiculoUsuario codvus_esc;

	public EstacionamentoControle() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_esc")
	public Long getCodigo() {
		return this.codigo_esc;
	}

	public void setCodigo(Long codigo) {
		this.codigo_esc = codigo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dhfim_esc")
	public Date getDataHoraSaida() {
		return this.dhfim_esc;
	}

	public void setDataHoraSaida(Date dataHora) {
		this.dhfim_esc = dataHora;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dhini_esc")
	public Date getDataHoraEntrada() {
		return this.dhini_esc;
	}

	public void setDataHoraEntrada(Date dataHora) {
		this.dhini_esc = dataHora;
	}

	@Column(name = "diaria_esc")
	public boolean getDiaria() {
		return this.diaria_esc;
	}

	public void setDiaria(boolean diaria) {
		this.diaria_esc = diaria;
	}

	// bi-directional many-to-one association to Vaga
	@ManyToOne
	@JoinColumn(name = "codvag_esc")
	public Vaga getVaga() {
		return this.codvag_esc;
	}

	public void setVaga(Vaga vaga) {
		this.codvag_esc = vaga;
	}

	// bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name = "codvei_esc")
	public Veiculo getVeiculo() {
		return this.codvei_esc;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.codvei_esc = veiculo;
	}

	// bi-directional many-to-one association to VeiculoUsuario
	@ManyToOne
	@JoinColumn(name = "codvus_esc")
	public VeiculoUsuario getVeiculoUsuario() {
		return this.codvus_esc;
	}

	public void setVeiculoUsuario(VeiculoUsuario veiculoUsuario) {
		this.codvus_esc = veiculoUsuario;
	}

}