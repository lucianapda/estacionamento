package br.com.estacionamento.model;

import java.util.List;

public interface VagaValorRepositoryCustom {
	List<VagaValor> obtemPeloNome(String nome);
}
