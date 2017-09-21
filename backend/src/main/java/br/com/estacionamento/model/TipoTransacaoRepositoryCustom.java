package br.com.estacionamento.model;

import java.util.List;

public interface TipoTransacaoRepositoryCustom {

	List<TipoTransacao> obtemPeloNome(String nome);
}
