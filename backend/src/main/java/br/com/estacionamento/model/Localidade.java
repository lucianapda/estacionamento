package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
/**
 * The persistent class for the localidade database table.
 * 
 */
@Entity
@NamedQuery(name="Localidade.findAll", query="SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo_loc;
	private int cep_loc;
	private String endere_loc;
	private String numero_loc;
	private List<Estacionamento> estacionamento;
	private Bairro codbai_loc;
	private Cidade codcid_loc;

	public Localidade() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_loc")
	public int getCodigo() {
		return this.codigo_loc;
	}

	public void setCodigo(int codigo) {
		this.codigo_loc = codigo;
	}


	@Column(name="cep_loc")
	public int getCep() {
		return this.cep_loc;
	}

	public void setCep(int cep) {
		this.cep_loc = cep;
	}


	@Column(name="endere_loc")
	public String getEndereco() {
		return this.endere_loc;
	}

	public void setEndereco(String endereco) {
		this.endere_loc = endereco;
	}


	@Column(name="numero_loc")
	public String getNumero() {
		return this.numero_loc;
	}

	public void setNumero(String numero) {
		this.numero_loc = numero;
	}


	//bi-directional many-to-one association to Estacionamento
	@OneToMany(mappedBy="localidade")
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


	//bi-directional many-to-one association to Bairro
	@ManyToOne
	@JoinColumn(name="codbai_loc")
	public Bairro getBairro() {
		return this.codbai_loc;
	}

	public void setBairro(Bairro bairro) {
		this.codbai_loc = bairro;
	}


	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="codcid_loc")
	public Cidade getCidade() {
		return this.codcid_loc;
	}

	public void setCidade(Cidade cidade) {
		this.codcid_loc = cidade;
	}
}