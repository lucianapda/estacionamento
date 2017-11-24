package br.com.estacionamento.model;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class UsuarioRepositoryImpl extends RepositoryBaseImpl implements UsuarioRepositoryCustom {

	@Override
	public List<Usuario> obtemPeloNome(String nome) {
		QUsuario usuarioAux = QUsuario.usuario;

		// Cria a query
		JPAQuery<Usuario> query = select(usuarioAux).from(usuarioAux);

		if (nome != null && !nome.isEmpty()) {
			query.where(usuarioAux.nome.containsIgnoreCase(nome));
		}

		query.orderBy(usuarioAux.nome.asc());

		return query.fetch();
	}

	@Override
	public long login(String email, String senha) {
		QUsuario usuarioAux = QUsuario.usuario;

		// Cria a query
		JPAQuery<Usuario> query = select(usuarioAux).from(usuarioAux);
		query.where(usuarioAux.email.eq(email));
		query.where(usuarioAux.senha.eq(senha));

		return query.fetch().get(0).getCodigo();
	}

	@Override
	public List<Usuario> obtemTodos() {
		QUsuario usuarioAux = QUsuario.usuario;

		// Cria a query
		JPAQuery<Usuario> query = select(usuarioAux).from(usuarioAux);
		query.orderBy(usuarioAux.nome.asc());

		return query.fetch();
	}

}
