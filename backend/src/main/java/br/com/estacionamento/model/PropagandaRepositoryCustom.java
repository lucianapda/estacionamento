package br.com.estacionamento.model;

import java.util.List;

public interface PropagandaRepositoryCustom {
	List<Propaganda> obtemPeloNome(String nome);
}
