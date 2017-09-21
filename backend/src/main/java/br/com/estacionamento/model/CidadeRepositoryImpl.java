package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class CidadeRepositoryImpl extends RepositoryBaseImpl implements CidadeRepositoryCustom {

	@Override
	public List<Cidade> obtemPeloNome(String nome) {
		QCidade bairroAux = QCidade.cidade;

		// Cria a query
		JPAQuery<Cidade> query = select(bairroAux).from(bairroAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(bairroAux.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(bairroAux.descricao.asc());

		return query.fetch();
	}
	
}