package br.com.estacionamento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the estacionamento database table.
 * 
 */
@Entity
@NamedQuery(name = "Estacionamento.findAll", query = "SELECT e FROM Estacionamento e")
public class Estacionamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo_est;
	private String cnpj_est;
	private Date datcri_est;
	private String nome_est;
	private int tmpres_est;
	private BigDecimal valres_est;
	private Localidade codloc_est;
	private Usuario codusu_est;
	private List<Estacionamento_img> imagemEstacionamento;
	private List<EstacionamentoLicenca> licencaEstacionamento;
	private List<PropagandaEstacionamento> propagandaEstacionamento;
	private List<Vaga> vaga;
	private List<VagaValor> valorVaga;

	public Estacionamento() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_est")
	public long getCodigo() {
		return this.codigo_est;
	}

	public void setCodigo(long codigo) {
		this.codigo_est = codigo;
	}

	@Column(name = "cnpj_est")
	public String getCnpj() {
		return this.cnpj_est;
	}

	public void setCnpj(String cnpj) {
		this.cnpj_est = cnpj;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datcri_est")
	public Date getDataCriacao() {
		return this.datcri_est;
	}

	public void setDataCriacao(Date data) {
		this.datcri_est = data;
	}

	@Column(name = "nome_est")
	public String getNome() {
		return this.nome_est;
	}

	public void setNome(String nome) {
		this.nome_est = nome;
	}

	@Column(name = "tmpres_est")
	public int getTempoReserva() {
		return this.tmpres_est;
	}

	public void setTempoReserva(int tempo) {
		this.tmpres_est = tempo;
	}

	@Column(name = "valres_est")
	public BigDecimal getValorReserva() {
		return this.valres_est;
	}

	public void setValorReserva(BigDecimal valor) {
		this.valres_est = valor;
	}

	// bi-directional many-to-one association to Localidade
	@JsonBackReference(value = "localidade-estacionamento")
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "codloc_est")
	public Localidade getLocalidade() {
		return this.codloc_est;
	}

	public void setLocalidade(Localidade localidade) {
		this.codloc_est = localidade;
	}

	// bi-directional many-to-one association to Usuario
	@JsonBackReference(value = "user-estacionamento")
	@ManyToOne
	@JoinColumn(name = "codusu_est")
	public Usuario getUsuario() {
		return this.codusu_est;
	}

	public void setUsuario(Usuario usuario) {
		this.codusu_est = usuario;
	}

	// bi-directional many-to-one association to EstacionamentoImg
	@OneToMany(mappedBy = "estacionamento")
	public List<Estacionamento_img> getImagemEstacionamento() {
		return this.imagemEstacionamento;
	}

	public void setImagemEstacionamento(List<Estacionamento_img> imagemEstacionamento) {
		this.imagemEstacionamento = imagemEstacionamento;
	}

	public Estacionamento_img addImagemEstacionamento(Estacionamento_img imagemEstacionamento) {
		getImagemEstacionamento().add(imagemEstacionamento);
		imagemEstacionamento.setEstacionamento(this);

		return imagemEstacionamento;
	}

	public Estacionamento_img removeImagemEstacionamento(Estacionamento_img imagemEstacionamento) {
		getImagemEstacionamento().remove(imagemEstacionamento);
		imagemEstacionamento.setEstacionamento(null);

		return imagemEstacionamento;
	}

	// bi-directional many-to-one association to EstacionamentoLicenca
	@OneToMany(mappedBy = "estacionamento")
	public List<EstacionamentoLicenca> getEstacionamentoLicenca() {
		return this.licencaEstacionamento;
	}

	public void setEstacionamentoLicenca(List<EstacionamentoLicenca> estacionamentoLicenca) {
		this.licencaEstacionamento = estacionamentoLicenca;
	}

	public EstacionamentoLicenca addEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicenca().add(estacionamentoLicenca);
		estacionamentoLicenca.setEstacionamento(this);

		return estacionamentoLicenca;
	}

	public EstacionamentoLicenca removeEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicenca().remove(estacionamentoLicenca);
		estacionamentoLicenca.setEstacionamento(null);

		return estacionamentoLicenca;
	}

	// bi-directional many-to-one association to PropagandaEstacionamento
	@OneToMany(mappedBy = "estacionamento")
	public List<PropagandaEstacionamento> getPropagandaEstacionamentos() {
		return this.propagandaEstacionamento;
	}

	public void setPropagandaEstacionamentos(List<PropagandaEstacionamento> propagandaEstacionamento) {
		this.propagandaEstacionamento = propagandaEstacionamento;
	}

	public PropagandaEstacionamento addPropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamentos().add(propagandaEstacionamento);
		propagandaEstacionamento.setEstacionamento(this);

		return propagandaEstacionamento;
	}

	public PropagandaEstacionamento removePropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamentos().remove(propagandaEstacionamento);
		propagandaEstacionamento.setEstacionamento(null);

		return propagandaEstacionamento;
	}

	// bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy = "estacionamento")
	public List<Vaga> getVaga() {
		return this.vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}

	public Vaga addVaga(Vaga vaga) {
		getVaga().add(vaga);
		vaga.setEstacionamento(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVaga().remove(vaga);
		vaga.setEstacionamento(null);

		return vaga;
	}

	// bi-directional many-to-one association to VagaValor
	@OneToMany(mappedBy = "estacionamento")
	public List<VagaValor> getVagaValor() {
		return this.valorVaga;
	}

	public void setVagaValor(List<VagaValor> vagaValor) {
		this.valorVaga = vagaValor;
	}

	public VagaValor addVagaValor(VagaValor vagaValor) {
		getVagaValor().add(vagaValor);
		vagaValor.setEstacionamento(this);

		return vagaValor;
	}

	public VagaValor removeVagaValor(VagaValor vagaValor) {
		getVagaValor().remove(vagaValor);
		vagaValor.setEstacionamento(null);

		return vagaValor;
	}

}