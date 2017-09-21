package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class PropagandaRepositoryImpl extends RepositoryBaseImpl implements PropagandaRepositoryCustom {
	@Override
	public List<Propaganda> obtemPeloNome(String nome) {
		QPropaganda propaganda = QPropaganda.propaganda;

		// Cria a query
		JPAQuery<Propaganda> query = select(propaganda).from(propaganda);

		if (nome != null && !nome.isEmpty()) {
			query.where(propaganda.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(propaganda.descricao.asc());

		return query.fetch();
	}
}
