package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class LocalidadeRepositoryImpl extends RepositoryBaseImpl implements LocalidadeRepositoryCustom {

	@Override
	public List<Localidade> obtemPeloNome(String nome) {
		QLocalidade localidade = QLocalidade.localidade;

		// Cria a query
		JPAQuery<Localidade> query = select(localidade).from(localidade);

		if (nome != null && !nome.isEmpty()) {
			query.where(localidade.endereco.containsIgnoreCase(nome));
		}

		query.orderBy(localidade.endereco.asc());

		return query.fetch();
	}

}
