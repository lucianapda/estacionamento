package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the vaga database table.
 * 
 */
@Entity
@NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v")
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo_vag;
	private boolean cobert_vag;
	private List<EstacionamentoControle> estacionamentoControles;
	private List<Reserva> reservas;
	private Estacionamento codest_vag;
	private VagaStatus codsta_vag;
	private VagaTipo codvat_vag;
	private VagaValor codvgv_vag;

	public Vaga() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_vag")
	public int getCodigo() {
		return this.codigo_vag;
	}

	public void setCodigo(int codigo) {
		this.codigo_vag = codigo;
	}

	@Column(name = "cobert_vag")
	public boolean getIsCoberta() {
		return this.cobert_vag;
	}

	public void setIsCoberta(boolean cobertVag) {
		this.cobert_vag = cobertVag;
	}

	// bi-directional many-to-one association to EstacionamentoControle
	@OneToMany(mappedBy = "vaga")
	public List<EstacionamentoControle> getEstacionamentoControles() {
		return this.estacionamentoControles;
	}

	public void setEstacionamentoControles(List<EstacionamentoControle> estacionamentoControles) {
		this.estacionamentoControles = estacionamentoControles;
	}

	public EstacionamentoControle addEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().add(estacionamentoControle);
		estacionamentoControle.setVaga(this);

		return estacionamentoControle;
	}

	public EstacionamentoControle removeEstacionamentoControle(EstacionamentoControle estacionamentoControle) {
		getEstacionamentoControles().remove(estacionamentoControle);
		estacionamentoControle.setVaga(null);

		return estacionamentoControle;
	}

	// bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy = "vaga")
	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setVaga(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setVaga(null);

		return reserva;
	}

	// bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumn(name = "codest_vag")
	public Estacionamento getEstacionamento() {
		return this.codest_vag;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.codest_vag = estacionamento;
	}

	// bi-directional many-to-one association to VagaStatus
	@ManyToOne
	@JoinColumn(name = "codsta_vag")
	public VagaStatus getVagaStatus() {
		return this.codsta_vag;
	}

	public void setVagaStatus(VagaStatus vagaStatus) {
		this.codsta_vag = vagaStatus;
	}

	// bi-directional many-to-one association to VagaTipo
	@ManyToOne
	@JoinColumn(name = "codvat_vag")
	public VagaTipo getVagaTipo() {
		return this.codvat_vag;
	}

	public void setVagaTipo(VagaTipo vagaTipo) {
		this.codvat_vag = vagaTipo;
	}

	// bi-directional many-to-one association to VagaValor
	@ManyToOne
	@JoinColumn(name = "codvgv_vag")
	public VagaValor getVagaValor() {
		return this.codvgv_vag;
	}

	public void setVagaValor(VagaValor vagaValor) {
		this.codvgv_vag = vagaValor;
	}
}