package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class VeiculoTipoRepositoryImpl extends RepositoryBaseImpl implements VeiculoTipoRepositoryCustom {
	@Override
	public List<VeiculoTipo> obtemPeloNome(String nome) {
		QVeiculoTipo veiculo = QVeiculoTipo.veiculoTipo;

		// Cria a query
		JPAQuery<VeiculoTipo> query = select(veiculo).from(veiculo);

		if (nome != null && !nome.isEmpty()) {
			query.where(veiculo.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(veiculo.descricao.asc());

		return query.fetch();
	}
}
