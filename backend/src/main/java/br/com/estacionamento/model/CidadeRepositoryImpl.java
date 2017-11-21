package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class CidadeRepositoryImpl extends RepositoryBaseImpl implements CidadeRepositoryCustom {

	@Override
	public List<Cidade> obtemPeloNome(String nome) {
		QCidade cidadeAux = QCidade.cidade;

		// Cria a query
		JPAQuery<Cidade> query = select(cidadeAux).from(cidadeAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(cidadeAux.descricao.containsIgnoreCase(nome));
		}

		query.orderBy(cidadeAux.descricao.asc());

		return query.fetch();
	}

	@Override
	public List<Cidade> obtemTodos() {
		QCidade cidadeAux = QCidade.cidade;

		// Cria a query
		JPAQuery<Cidade> query = select(cidadeAux).from(cidadeAux);
		query.orderBy(cidadeAux.descricao.asc());
		query.where(cidadeAux.pais.codigo.eq((long) 1));
		
		return query.fetch();
	}
	
}