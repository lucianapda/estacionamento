package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class BairroRepositoryImpl extends RepositoryBaseImpl implements BairroRepositoryCustom {

	@Override
	public List<Bairro> obtemPeloNome(String nome) {
		QBairro bairroAux = QBairro.bairro;

		// Cria a query
		JPAQuery<Bairro> query = select(bairroAux).from(bairroAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(bairroAux.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(bairroAux.descricao.asc());

		return query.fetch();
	}

	@Override
	public List<Bairro> obtemTodos() {
		QBairro bairroAux = QBairro.bairro;
		JPAQuery<Bairro> query = select(bairroAux).from(bairroAux);

		query.orderBy(bairroAux.descricao.asc());

		return query.fetch();
	}

}
