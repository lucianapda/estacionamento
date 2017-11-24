package br.com.estacionamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the usuario_img database table.
 * 
 */
@Entity
@Table(name = "usuario_img")
@NamedQuery(name = "UsuarioImg.findAll", query = "SELECT u FROM UsuarioImg u")
public class UsuarioImg implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String imagem;
	private Usuario usuario;

	public UsuarioImg() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_uimg")
	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Lob
	@Column(name = "img_uimg")
	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	// bi-directional many-to-one association to Usuario
	@JsonBackReference(value = "user-imgUsu")
	@ManyToOne
	@JoinColumn(name = "codusu_uimg")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}