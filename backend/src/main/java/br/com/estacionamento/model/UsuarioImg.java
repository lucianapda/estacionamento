package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_img database table.
 * 
 */
@Entity
@Table(name="usuario_img")
@NamedQuery(name="UsuarioImg.findAll", query="SELECT u FROM UsuarioImg u")
public class UsuarioImg implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private byte[] imagem;
	private Usuario usuario;

	public UsuarioImg() {
	}


	@Id
	@Column(name="codigo_uimg")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Lob
	@Column(name="img_uimg")
	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="codusu_uimg")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}