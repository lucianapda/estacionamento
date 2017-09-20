package br.com.estacionamento.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the propaganda database table.
 * 
 */
@Entity
@NamedQuery(name = "Propaganda.findAll", query = "SELECT p FROM Propaganda p")
public class Propaganda implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo_pro;
	private String descri_pro;
	private List<PropagandaEstacionamento> propagandaEstacionamento;
	private List<PropagandaImg> imagemPropaganda;

	public Propaganda() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_pro")
	public int getCodigo() {
		return this.codigo_pro;
	}

	public void setCodigo(int codigo) {
		this.codigo_pro = codigo;
	}

	@Lob
	@Column(name = "descri_pro")
	public String getDescricao() {
		return this.descri_pro;
	}

	public void setDescricao(String descricao) {
		this.descri_pro = descricao;
	}

	// bi-directional many-to-one association to PropagandaEstacionamento
	@OneToMany(mappedBy = "propaganda")
	public List<PropagandaEstacionamento> getPropagandaEstacionamento() {
		return this.propagandaEstacionamento;
	}

	public void setPropagandaEstacionamento(List<PropagandaEstacionamento> propagandaEstacionamento) {
		this.propagandaEstacionamento = propagandaEstacionamento;
	}

	public PropagandaEstacionamento addPropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamento().add(propagandaEstacionamento);
		propagandaEstacionamento.setPropaganda(this);

		return propagandaEstacionamento;
	}

	public PropagandaEstacionamento removePropagandaEstacionamento(PropagandaEstacionamento propagandaEstacionamento) {
		getPropagandaEstacionamento().remove(propagandaEstacionamento);
		propagandaEstacionamento.setPropaganda(null);

		return propagandaEstacionamento;
	}

	// bi-directional many-to-one association to PropagandaImg
	@OneToMany(mappedBy = "propaganda")
	public List<PropagandaImg> getImagemPropaganda() {
		return this.imagemPropaganda;
	}

	public void setImagemPropaganda(List<PropagandaImg> imagemPropaganda) {
		this.imagemPropaganda = imagemPropaganda;
	}

	public PropagandaImg addImagemPropaganda(PropagandaImg imagemPropaganda) {
		getImagemPropaganda().add(imagemPropaganda);
		imagemPropaganda.setPropaganda(this);

		return imagemPropaganda;
	}

	public PropagandaImg removeImagemPropaganda(PropagandaImg imagemPropaganda) {
		getImagemPropaganda().remove(imagemPropaganda);
		imagemPropaganda.setPropaganda(null);

		return imagemPropaganda;
	}
}