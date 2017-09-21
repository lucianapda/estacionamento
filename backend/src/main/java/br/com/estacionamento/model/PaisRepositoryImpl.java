package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class PaisRepositoryImpl extends RepositoryBaseImpl implements PaisRepositoryCustom {

	@Override
	public List<Pais> obtemPeloNome(String nome) {
		QPais pais = QPais.pais;

		// Cria a query
		JPAQuery<Pais> query = select(pais).from(pais);

		if (nome != null && !nome.isEmpty()) {
			query.where(pais.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(pais.descricao.asc());

		return query.fetch();
	}

}
