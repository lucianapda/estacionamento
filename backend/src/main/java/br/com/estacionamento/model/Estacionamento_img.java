package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the estacionamento_img database table.
 * 
 */
@Entity
@NamedQuery(name = "Estacionamento_img.findAll", query = "SELECT e FROM Estacionamento_img e")
public class Estacionamento_img implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo_eimg;
	private byte[] img_eimg;
	private Estacionamento codest_eimg;

	public Estacionamento_img() {
	}

	@Id
	@Column(name = "codigo_eimg")
	public int getCodigo() {
		return this.codigo_eimg;
	}

	public void setCodigo(int codigo) {
		this.codigo_eimg = codigo;
	}

	@Lob
	@Column(name = "img_eimg")
	public byte[] getImagem() {
		return this.img_eimg;
	}

	public void setImagem(byte[] imgagem) {
		this.img_eimg = imgagem;
	}

	// bi-directional many-to-one association to Estacionamento
	@ManyToOne
	@JoinColumn(name = "codest_eimg")
	public Estacionamento getEstacionamento() {
		return this.codest_eimg;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.codest_eimg = estacionamento;
	}
}