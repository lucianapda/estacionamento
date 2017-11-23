package br.com.estacionamento.model;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.estacionamento.commons.RepositoryBaseImpl;

public class UsuarioImgRepositoryImpl extends RepositoryBaseImpl implements UsuarioImgRepositoryCustom {

	@Override
	public UsuarioImg obtemPeloCodigoUsu(long codigo) {
		QUsuarioImg usuarioAux = QUsuarioImg.usuarioImg;

		// Cria a query
		JPAQuery<UsuarioImg> query = select(usuarioAux).from(usuarioAux);
		query.where(usuarioAux.usuario.codigo.eq(codigo));

		return query.fetch().get(0);
	}

}
