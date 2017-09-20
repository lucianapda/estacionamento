package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transacao database table.
 * 
 */
@Entity
@NamedQuery(name="Transacao.findAll", query="SELECT t FROM Transacao t")
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Date dataHora;
	private String descricao;
	private int codigoLigacao;
	private BigDecimal valor;
	private FormaPagamento formaPagamento;
	private TipoTransacao tipoTransacao;
	private Usuario usuario;

	public Transacao() {
	}


	@Id
	@Column(name="codigo_tra")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dathor_tra")
	public Date getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	@Column(name="descri_tra")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(name="subcod_tra")
	public int getCodigoLigacao() {
		return this.codigoLigacao;
	}

	public void setCodigoLigacao(int codigoLigacao) {
		this.codigoLigacao = codigoLigacao;
	}


	@Column(name="valor_tra")
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to FormaPagamento
	@ManyToOne
	@JoinColumn(name="codfpg_tra")
	public FormaPagamento getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	//bi-directional many-to-one association to TipoTransacao
	@ManyToOne
	@JoinColumn(name="codtip_tra")
	public TipoTransacao getTipoTransacao() {
		return this.tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codusu_tra")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}