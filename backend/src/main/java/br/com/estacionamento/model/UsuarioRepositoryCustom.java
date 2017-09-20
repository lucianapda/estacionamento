package br.com.estacionamento.model;

import java.util.List;

public interface UsuarioRepositoryCustom {

	List<Usuario> obtemPeloNome(String nome);
}
