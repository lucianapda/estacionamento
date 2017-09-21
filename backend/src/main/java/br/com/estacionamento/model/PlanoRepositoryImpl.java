package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class PlanoRepositoryImpl extends RepositoryBaseImpl implements PlanoRepositoryCustom {

	@Override
	public List<Plano> obtemPeloNome(String nome) {
		QPlano plano = QPlano.plano;

		// Cria a query
		JPAQuery<Plano> query = select(plano).from(plano);

		if (nome != null && !nome.isEmpty()) {
			query.where(plano.nome.containsIgnoreCase(nome));
		}

		query.orderBy(plano.nome.asc());

		return query.fetch();
	}
	
}
