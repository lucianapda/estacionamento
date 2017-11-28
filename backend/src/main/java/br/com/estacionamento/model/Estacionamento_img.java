package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the estacionamento_img database table.
 * 
 */
@Entity
@NamedQuery(name = "Estacionamento_img.findAll", query = "SELECT e FROM Estacionamento_img e")
public class Estacionamento_img implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo_eimg;
	private String img_eimg;
	private Estacionamento codest_eimg;

	public Estacionamento_img() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_eimg")
	public Long getCodigo() {
		return this.codigo_eimg;
	}

	public void setCodigo(Long codigo) {
		this.codigo_eimg = codigo;
	}

	@Lob
	@Column(name = "img_eimg")
	public String getImagem() {
		return this.img_eimg;
	}

	public void setImagem(String imgagem) {
		this.img_eimg = imgagem;
	}

	// bi-directional many-to-one association to Estacionamento
	@JsonBackReference(value = "estacionamento-imgEstacionamento")
	@ManyToOne
	@JoinColumn(name = "codest_eimg")
	public Estacionamento getEstacionamento() {
		return this.codest_eimg;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.codest_eimg = estacionamento;
	}
}