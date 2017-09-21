package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class BandeiraCartaoRepositoryImpl extends RepositoryBaseImpl implements BandeiraCartaoRepositoryCustom {
	@Override
	public List<BandeiraCartao> obtemPeloNome(String nome) {
		QBandeiraCartao bandeiraCartao = QBandeiraCartao.bandeiraCartao;

		// Cria a query
		JPAQuery<BandeiraCartao> query = select(bandeiraCartao).from(bandeiraCartao);

		if (nome != null && !nome.isEmpty()) {
			query.where(bandeiraCartao.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(bandeiraCartao.descricao.asc());

		return query.fetch();
	}
}
