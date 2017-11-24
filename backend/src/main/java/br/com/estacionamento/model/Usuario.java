package br.com.estacionamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private long codigo;
	private String cpf;
	private String email;
	private String telefone;
	private String nome;
	private String senha;
	private String sexo;
	private Localidade localidade;
	private List<Estacionamento> estacionamentos;
	private List<EstacionamentoLicenca> estacionamentoLicencas;
	private List<Reserva> reservas;
	private List<Transacao> transacaos;
	private CartaoCredito cartaoCredito;
	private List<UsuarioImg> usuarioImgs;
	private List<VeiculoUsuario> veiculoUsuarios;

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "cpf_usu")
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "email_usu")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fone_usu")
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "nome_usu")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "senha_usu")
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@JsonBackReference(value = "user-localidade")
	@ManyToOne
	@JoinColumn(name = "codloc_usu")
	public Localidade getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	@Column(name = "sexo_usu")
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	// bi-directional many-to-one association to Estacionamento
	@JsonManagedReference(value = "user-estacionamento")
	@OneToMany(mappedBy = "usuario")
	public List<Estacionamento> getEstacionamentos() {
		return this.estacionamentos;
	}

	public void setEstacionamentos(List<Estacionamento> estacionamentos) {
		this.estacionamentos = estacionamentos;
	}

	public Estacionamento addEstacionamento(Estacionamento estacionamento) {
		getEstacionamentos().add(estacionamento);
		estacionamento.setUsuario(this);

		return estacionamento;
	}

	public Estacionamento removeEstacionamento(Estacionamento estacionamento) {
		getEstacionamentos().remove(estacionamento);
		estacionamento.setUsuario(null);

		return estacionamento;
	}

	// bi-directional many-to-one association to EstacionamentoLicenca
	@OneToMany(mappedBy = "usuario")
	public List<EstacionamentoLicenca> getEstacionamentoLicencas() {
		return this.estacionamentoLicencas;
	}

	public void setEstacionamentoLicencas(List<EstacionamentoLicenca> estacionamentoLicencas) {
		this.estacionamentoLicencas = estacionamentoLicencas;
	}

	public EstacionamentoLicenca addEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicencas().add(estacionamentoLicenca);
		estacionamentoLicenca.setUsuario(this);

		return estacionamentoLicenca;
	}

	public EstacionamentoLicenca removeEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicencas().remove(estacionamentoLicenca);
		estacionamentoLicenca.setUsuario(null);

		return estacionamentoLicenca;
	}

	// bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy = "usuario")
	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setUsuario(null);

		return reserva;
	}

	// bi-directional many-to-one association to Transacao
	@OneToMany(mappedBy = "usuario")
	public List<Transacao> getTransacaos() {
		return this.transacaos;
	}

	public void setTransacaos(List<Transacao> transacaos) {
		this.transacaos = transacaos;
	}

	public Transacao addTransacao(Transacao transacao) {
		getTransacaos().add(transacao);
		transacao.setUsuario(this);

		return transacao;
	}

	public Transacao removeTransacao(Transacao transacao) {
		getTransacaos().remove(transacao);
		transacao.setUsuario(null);

		return transacao;
	}

	// bi-directional many-to-one association to CartaoCredito
	@ManyToOne
	@JoinColumn(name = "codctc_usu")
	public CartaoCredito getCartaoCredito() {
		return this.cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	// bi-directional many-to-one association to UsuarioImg
	@JsonManagedReference (value = "user-imgUsu")
	@OneToMany(mappedBy = "usuario")
	public List<UsuarioImg> getUsuarioImgs() {
		return this.usuarioImgs;
	}

	public void setUsuarioImgs(List<UsuarioImg> usuarioImgs) {
		this.usuarioImgs = usuarioImgs;
	}

	public UsuarioImg addUsuarioImg(UsuarioImg usuarioImg) {
		getUsuarioImgs().add(usuarioImg);
		usuarioImg.setUsuario(this);

		return usuarioImg;
	}

	public UsuarioImg removeUsuarioImg(UsuarioImg usuarioImg) {
		getUsuarioImgs().remove(usuarioImg);
		usuarioImg.setUsuario(null);

		return usuarioImg;
	}

	// bi-directional many-to-one association to VeiculoUsuario
	@OneToMany(mappedBy = "usuario")
	public List<VeiculoUsuario> getVeiculoUsuarios() {
		return this.veiculoUsuarios;
	}

	public void setVeiculoUsuarios(List<VeiculoUsuario> veiculoUsuarios) {
		this.veiculoUsuarios = veiculoUsuarios;
	}

	public VeiculoUsuario addVeiculoUsuario(VeiculoUsuario veiculoUsuario) {
		getVeiculoUsuarios().add(veiculoUsuario);
		veiculoUsuario.setUsuario(this);

		return veiculoUsuario;
	}

	public VeiculoUsuario removeVeiculoUsuario(VeiculoUsuario veiculoUsuario) {
		getVeiculoUsuarios().remove(veiculoUsuario);
		veiculoUsuario.setUsuario(null);

		return veiculoUsuario;
	}

}