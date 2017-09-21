package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class VagaStatusRepositoryImpl extends RepositoryBaseImpl implements VagaStatusRepositoryCustom {
	@Override
	public List<VagaStatus> obtemPeloNome(String nome) {
		QVagaStatus vaga = QVagaStatus.vagaStatus;

		// Cria a query
		JPAQuery<VagaStatus> query = select(vaga).from(vaga);

		if (nome != null && !nome.isEmpty()) {
			query.where(vaga.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(vaga.descricao.asc());

		return query.fetch();
	}
}
