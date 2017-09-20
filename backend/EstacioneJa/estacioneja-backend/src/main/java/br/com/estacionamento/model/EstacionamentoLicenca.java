package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estacionamento_licenca database table.
 * 
 */
@Entity
@Table(name="estacionamento_licenca")
@NamedQuery(name="EstacionamentoLicenca.findAll", query="SELECT e FROM EstacionamentoLicenca e")
public class EstacionamentoLicenca implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private UsuarioTipo tipoUsuario;
	private Estacionamento estacionamento;
	private Usuario usuario;

	public EstacionamentoLicenca() {
	}


	@Id
	@Column(name="codigo_eli")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	//bi-directional many-to-one association to UsuarioTipo
	@ManyToOne
	@JoinColumn(name="codutp_eli")
	public UsuarioTipo getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(UsuarioTipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	//bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumn(name="codest_eli")
	public Estacionamento getEstacionamento() {
		return this.estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codusu_eli")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}