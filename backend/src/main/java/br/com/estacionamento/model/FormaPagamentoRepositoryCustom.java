package br.com.estacionamento.model;

import java.util.List;

public interface FormaPagamentoRepositoryCustom {

	List<FormaPagamento> obtemPeloNome(String nome);

}
