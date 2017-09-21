package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class FormaPagamentoRepositoryImpl extends RepositoryBaseImpl implements FormaPagamentoRepositoryCustom {

	@Override
	public List<FormaPagamento> obtemPeloNome(String nome) {
		QFormaPagamento formaPagamento = QFormaPagamento.formaPagamento;

		// Cria a query
		JPAQuery<FormaPagamento> query = select(formaPagamento).from(formaPagamento);

		if (nome != null && !nome.isEmpty()) {
			query.where(formaPagamento.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(formaPagamento.descricao.asc());

		return query.fetch();
	}

}
