package br.com.estacionamento.model;

import java.util.List;

public interface LocalidadeRepositoryCustom {
	List<Localidade> obtemPeloNome(String nome);
}
