package br.com.estacionamento.commons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQuery;

public class RepositoryBaseImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public <U> JPAQuery<U> select(Expression<U> expr) {
        return new JPAQuery<>(entityManager).select(expr);
    }

    public JPAQuery<Tuple> select(Expression<?>... exprs) {
        return new JPAQuery<>(entityManager).select(exprs);
    }

}
