package br.com.estacionamento.model;

import java.util.List;

import br.com.estacionamento.commons.RepositoryBase;

public interface BandeiraCartaoRepository extends RepositoryBase<BandeiraCartao>, BandeiraCartaoRepositoryCustom {

	List<BandeiraCartao> obtemPeloNome(String nome);
}
