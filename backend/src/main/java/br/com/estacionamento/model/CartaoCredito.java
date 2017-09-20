package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cartao_credito database table.
 * 
 */
@Entity
@Table(name="cartao_credito")
@NamedQuery(name="CartaoCredito.findAll", query="SELECT c FROM CartaoCredito c")
public class CartaoCredito implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int codigoSeguranca;
	private String cpfTitular;
	private Date dataVencimento;
	private String nomeTitular;
	private int numero;
	private BandeiraCartao bandeiraCartao;
	private List<Usuario> usuario;

	public CartaoCredito() {
	}


	@Id
	@Column(name="codigo_ctc")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="codseg_ctc")
	public int getCodigoSeguranca() {
		return this.codigoSeguranca;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}


	@Column(name="cpftit_ctc")
	public String getCpfTitular() {
		return this.cpfTitular;
	}

	public void setCpfTitular(String cpf) {
		this.cpfTitular = cpf;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="datven_ctc")
	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date data) {
		this.dataVencimento = data;
	}


	@Column(name="nomtit_ctc")
	public String getNomeTitular() {
		return this.nomeTitular;
	}

	public void setNomeTitular(String nome) {
		this.nomeTitular = nome;
	}


	@Column(name="numero_ctc")
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	//bi-directional many-to-one association to BandeiraCartao
	@ManyToOne
	@JoinColumn(name="codbct_ctc")
	public BandeiraCartao getBandeiraCartao() {
		return this.bandeiraCartao;
	}

	public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}


	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cartaoCredito")
	public List<Usuario> getUsuario() {
		return this.usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuario().add(usuario);
		usuario.setCartaoCredito(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuario().remove(usuario);
		usuario.setCartaoCredito(null);

		return usuario;
	}

}