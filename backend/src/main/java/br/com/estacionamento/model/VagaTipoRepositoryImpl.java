package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class VagaTipoRepositoryImpl extends RepositoryBaseImpl implements VagaTipoRepositoryCustom {
	@Override
	public List<VagaTipo> obtemPeloNome(String nome) {
		QVagaTipo vaga = QVagaTipo.vagaTipo;

		// Cria a query
		JPAQuery<VagaTipo> query = select(vaga).from(vaga);

		if (nome != null && !nome.isEmpty()) {
			query.where(vaga.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(vaga.descricao.asc());

		return query.fetch();
	}
}
