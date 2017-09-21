package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class VagaValorRepositoryImpl extends RepositoryBaseImpl implements VagaValorRepositoryCustom {
	@Override
	public List<VagaValor> obtemPeloNome(String nome) {
		QVagaValor vaga = QVagaValor.vagaValor;

		// Cria a query
		JPAQuery<VagaValor> query = select(vaga).from(vaga);

		if (nome != null && !nome.isEmpty()) {
			query.where(vaga.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(vaga.descricao.asc());

		return query.fetch();
	}
}
