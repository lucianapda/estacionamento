package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class VeiculoRepositoryImpl extends RepositoryBaseImpl implements VeiculoRepositoryCustom {
	@Override
	public List<Veiculo> obtemPeloNome(String nome) {
		QVeiculo veiculo = QVeiculo.veiculo;

		// Cria a query
		JPAQuery<Veiculo> query = select(veiculo).from(veiculo);

		if (nome != null && !nome.isEmpty()) {
			query.where(veiculo.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(veiculo.descricao.asc());

		return query.fetch();
	}
}
