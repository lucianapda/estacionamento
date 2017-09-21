package br.com.estacionamento.model;

import java.util.List;

public interface VeiculoRepositoryCustom {
	List<Veiculo> obtemPeloNome(String nome);
}
