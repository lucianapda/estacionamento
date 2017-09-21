package br.com.estacionamento.model;

import java.util.List;

public interface VagaStatusRepositoryCustom {
	
	List<VagaStatus> obtemPeloNome(String nome);

}
