package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class EstacionamentoRepositoryImpl extends RepositoryBaseImpl implements EstacionamentoRepositoryCustom {

	/**
	 * Este m�todo retorna todos os registros da tabela Exemplo que cont�m a descri��o informada no par�metro
	 */
	@Override
	public List<Estacionamento> obtemPeloNome(String nome) {
		QEstacionamento estacionamentoAux = QEstacionamento.estacionamento;

		// Cria a query
		JPAQuery<Estacionamento> query = select(estacionamentoAux).from(estacionamentoAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(estacionamentoAux.nome.containsIgnoreCase(nome));
		}

		query.orderBy(estacionamentoAux.nome.asc());

		return query.fetch();
	}

}
