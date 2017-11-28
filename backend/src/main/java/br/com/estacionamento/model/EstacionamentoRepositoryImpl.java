package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class EstacionamentoRepositoryImpl extends RepositoryBaseImpl implements EstacionamentoRepositoryCustom {

	@Override
	public List<Estacionamento> obtemPeloNome(String nome) {
		QEstacionamento estacionamentoAux = QEstacionamento.estacionamento;

		// Cria a query
		JPAQuery<Estacionamento> query = select(estacionamentoAux).from(estacionamentoAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(estacionamentoAux.nome.containsIgnoreCase(nome)
					.or(estacionamentoAux.localidade.bairro.descricao.containsIgnoreCase(nome))
					.or(estacionamentoAux.localidade.cidade.descricao.containsIgnoreCase(nome))
					.or(estacionamentoAux.nome.containsIgnoreCase(nome)));
		}

		query.orderBy(estacionamentoAux.nome.asc());

		return query.fetch();
	}

	@Override
	public List<Estacionamento> obtemPeloUsuario(long codigoUsuario) {
		QEstacionamento estacionamentoAux = QEstacionamento.estacionamento;

		JPAQuery<Estacionamento> query = select(estacionamentoAux).from(estacionamentoAux);
		query.where(estacionamentoAux.usuario.codigo.eq(codigoUsuario));
		
		query.orderBy(estacionamentoAux.nome.asc());

		return query.fetch();
	}

	@Override
	public List<Estacionamento> obtemTodos() {
		QEstacionamento estacionamentoAux = QEstacionamento.estacionamento;

		JPAQuery<Estacionamento> query = select(estacionamentoAux).from(estacionamentoAux);
		query.orderBy(estacionamentoAux.nome.asc());

		return query.fetch();
	}

}
