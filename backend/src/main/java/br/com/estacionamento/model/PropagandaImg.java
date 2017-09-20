package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propaganda_img database table.
 * 
 */
@Entity
@Table(name="propaganda_img")
@NamedQuery(name="PropagandaImg.findAll", query="SELECT p FROM PropagandaImg p")
public class PropagandaImg implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private byte[] imagem;
	private Propaganda propaganda;

	public PropagandaImg() {
	}


	@Id
	@Column(name="codigo_proi")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Lob
	@Column(name="img_proi")
	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}


	//bi-directional many-to-one association to Propaganda
	@ManyToOne
	@JoinColumn(name="codpro_proi")
	public Propaganda getPropaganda() {
		return this.propaganda;
	}

	public void setPropaganda(Propaganda propaganda) {
		this.propaganda = propaganda;
	}

}