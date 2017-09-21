package br.com.estacionamento.model;

import java.util.List;

public interface PlanoRepositoryCustom {
	List<Plano> obtemPeloNome(String nome);
}
