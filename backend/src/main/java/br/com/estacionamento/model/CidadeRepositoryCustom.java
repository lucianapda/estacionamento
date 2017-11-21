package br.com.estacionamento.model;

import java.util.List;

public interface CidadeRepositoryCustom {

	List<Cidade> obtemPeloNome(String nome);
	List<Cidade> obtemTodos();
	
}