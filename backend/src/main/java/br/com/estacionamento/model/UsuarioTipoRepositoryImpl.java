package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class UsuarioTipoRepositoryImpl extends RepositoryBaseImpl implements UsuarioTipoRepositoryCustom {

	@Override
	public List<UsuarioTipo> obtemPeloNome(String nome) {
		QUsuarioTipo usuarioTipo = QUsuarioTipo.usuarioTipo;

		// Cria a query
		JPAQuery<UsuarioTipo> query = select(usuarioTipo).from(usuarioTipo);

		if (nome != null && !nome.isEmpty()) {
			query.where(usuarioTipo.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(usuarioTipo.descricao.asc());

		return query.fetch();
	}

	
}
