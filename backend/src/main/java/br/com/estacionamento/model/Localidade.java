package br.com.estacionamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the localidade database table.
 * 
 */
@Entity
@NamedQuery(name = "Localidade.findAll", query = "SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo_loc;
	private String cep_loc;
	private String endere_loc;
	private String numero_loc;
	private String estado_loc;
	private List<Estacionamento> estacionamento;
	private Bairro codbai_loc;
	private Cidade codcid_loc;
	private List<Usuario> usuarios;

	public Localidade() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_loc")
	public Long getCodigo() {
		return this.codigo_loc;
	}

	public void setCodigo(Long codigo) {
		this.codigo_loc = codigo;
	}

	@Column(name = "estado_loc")
	public String getEstado() {
		return this.estado_loc;
	}

	public void setEstado(String estado) {
		this.estado_loc = estado;
	}

	@Column(name = "cep_loc")
	public String getCep() {
		return this.cep_loc;
	}

	public void setCep(String cep) {
		this.cep_loc = cep;
	}

	@Column(name = "endere_loc")
	public String getEndereco() {
		return this.endere_loc;
	}

	public void setEndereco(String endereco) {
		this.endere_loc = endereco;
	}

	@Column(name = "numero_loc")
	public String getNumero() {
		return this.numero_loc;
	}

	public void setNumero(String numero) {
		this.numero_loc = numero;
	}

	// bi-directional many-to-one association to Estacionamento
	@JsonManagedReference(value = "localidade-estacionamento")
	@OneToMany(mappedBy = "localidade")
	public List<Estacionamento> getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(List<Estacionamento> estacionamento) {
		this.estacionamento = estacionamento;
	}

	public Estacionamento addEstacionamento(Estacionamento estacionamento) {
		getEstacionamento().add(estacionamento);
		estacionamento.setLocalidade(this);

		return estacionamento;
	}

	public Estacionamento removeEstacionamento(Estacionamento estacionamento) {
		getEstacionamento().remove(estacionamento);
		estacionamento.setLocalidade(null);

		return estacionamento;
	}

	// bi-directional many-to-one association to Bairro
	@JsonManagedReference (value="localidade-bairro")
	@ManyToOne
	@JoinColumn(name = "codbai_loc")
	public Bairro getBairro() {
		return this.codbai_loc;
	}

	public void setBairro(Bairro bairro) {
		this.codbai_loc = bairro;
	}

	// bi-directional many-to-one association to Cidade
	@JsonManagedReference (value="localidade-cidade")
	@ManyToOne
	@JoinColumn(name = "codcid_loc")
	public Cidade getCidade() {
		return this.codcid_loc;
	}

	public void setCidade(Cidade cidade) {
		this.codcid_loc = cidade;
	}

	@JsonBackReference(value = "user-localidade")
	@OneToMany(mappedBy = "localidade")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setLocalidade(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setLocalidade(null);

		return usuario;
	}
}