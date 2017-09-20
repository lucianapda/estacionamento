package br.com.estacionamento.model;

import java.util.List;

public interface EstacionamentoRepositoryCustom {

	List<Estacionamento> obtemPeloNome(String nome);
}
