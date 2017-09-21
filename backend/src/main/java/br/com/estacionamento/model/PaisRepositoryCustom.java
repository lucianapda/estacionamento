package br.com.estacionamento.model;

import java.util.List;

public interface PaisRepositoryCustom {

	List<Pais> obtemPeloNome(String nome);
	
}
