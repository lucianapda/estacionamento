package br.com.estacionamento.model;

import java.util.List;

public interface BandeiraCartaoRepositoryCustom {

	List<BandeiraCartao> obtemPeloNome(String nome);

}
