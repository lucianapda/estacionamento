package br.com.estacionamento.model;

import java.util.List;

public interface VagaTipoRepositoryCustom {
	List<VagaTipo> obtemPeloNome(String nome);
}
