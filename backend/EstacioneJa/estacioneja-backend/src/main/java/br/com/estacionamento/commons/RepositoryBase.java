package br.com.estacionamento.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface RepositoryBase<T> extends QueryDslPredicateExecutor<T>, JpaRepository<T, Long> {

}
