package br.com.estacionamento.model;

import java.util.List;

public interface VeiculoTipoRepositoryCustom {
	List<VeiculoTipo> obtemPeloNome(String nome);
}
