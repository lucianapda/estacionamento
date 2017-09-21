package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class TipoTransacaoRepositoryImpl extends RepositoryBaseImpl implements TipoTransacaoRepositoryCustom {

	@Override
	public List<TipoTransacao> obtemPeloNome(String nome) {
		QTipoTransacao tipoTransacao = QTipoTransacao.tipoTransacao;

		// Cria a query
		JPAQuery<TipoTransacao> query = select(tipoTransacao).from(tipoTransacao);

		if (nome != null && !nome.isEmpty()) {
			query.where(tipoTransacao.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(tipoTransacao.descricao.asc());

		return query.fetch();
	}

}
