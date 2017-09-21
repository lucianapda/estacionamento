package br.com.estacionamento.model;

import java.util.List;

public interface UsuarioTipoRepositoryCustom {
	
	List<UsuarioTipo> obtemPeloNome(String nome);

}