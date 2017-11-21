package br.com.estacionamento.model;

import java.util.List;

public interface BairroRepositoryCustom {

	List<Bairro> obtemPeloNome(String nome);
	List<Bairro> obtemPelaCidade(long codigoCidade);
	List<Bairro> obtemTodos();
}
