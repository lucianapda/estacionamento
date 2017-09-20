package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario_tipo database table.
 * 
 */
@Entity
@Table(name="usuario_tipo")
@NamedQuery(name="UsuarioTipo.findAll", query="SELECT u FROM UsuarioTipo u")
public class UsuarioTipo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private List<EstacionamentoLicenca> estacionamentoLicencas;

	public UsuarioTipo() {
	}


	@Id
	@Column(name="codigo_utp")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="descri_utp")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to EstacionamentoLicenca
	@OneToMany(mappedBy="tipoUsuario")
	public List<EstacionamentoLicenca> getEstacionamentoLicencas() {
		return this.estacionamentoLicencas;
	}

	public void setEstacionamentoLicencas(List<EstacionamentoLicenca> estacionamentoLicencas) {
		this.estacionamentoLicencas = estacionamentoLicencas;
	}

	public EstacionamentoLicenca addEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicencas().add(estacionamentoLicenca);
		estacionamentoLicenca.setTipoUsuario(this);

		return estacionamentoLicenca;
	}

	public EstacionamentoLicenca removeEstacionamentoLicenca(EstacionamentoLicenca estacionamentoLicenca) {
		getEstacionamentoLicencas().remove(estacionamentoLicenca);
		estacionamentoLicenca.setTipoUsuario(null);

		return estacionamentoLicenca;
	}

}