package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the bandeira_cartao database table.
 * 
 */
@Entity
@Table(name="bandeira_cartao")
@NamedQuery(name="BandeiraCartao.findAll", query="SELECT b FROM BandeiraCartao b")
public class BandeiraCartao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String descricao;
	private List<CartaoCredito> cartaoCredito;

	public BandeiraCartao() {
	}

	@Id
	@Column(name="codigo_bct")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigoBct) {
		this.codigo = codigoBct;
	}


	@Column(name="descri_bct")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descriBct) {
		this.descricao = descriBct;
	}


	//bi-directional many-to-one association to CartaoCredito
	@OneToMany(mappedBy="bandeiraCartao")
	public List<CartaoCredito> getCartaoCredito() {
		return this.cartaoCredito;
	}

	public void setCartaoCredito(List<CartaoCredito> cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public CartaoCredito addCartaoCredito(CartaoCredito cartaoCredito) {
		getCartaoCredito().add(cartaoCredito);
		cartaoCredito.setBandeiraCartao(this);

		return cartaoCredito;
	}

	public CartaoCredito removeCartaoCredito(CartaoCredito cartaoCredito) {
		getCartaoCredito().remove(cartaoCredito);
		cartaoCredito.setBandeiraCartao(null);

		return cartaoCredito;
	}

}