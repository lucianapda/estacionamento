package br.com.estacionamento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.model.Usuario;
import br.com.estacionamento.model.UsuarioRepository;

@RestController
public class UsuarioController {

	@Inject
	private UsuarioRepository usuarioRepository;

	@RequestMapping(path = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUsuarioNome(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Usuario> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = usuarioRepository.obtemPeloNome(nome);
		} else {
			if (usuarioRepository.exists(codigo)) {
				Usuario usuario = usuarioRepository.findOne(codigo);
				listaRetorno.add(usuario);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Usuario>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Usuario>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {

		if (usuario != null) {
			try {
				usuarioRepository.saveAndFlush(usuario);
			} catch (Exception e) {
				return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(path = "/usuario", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUsuario(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (usuarioRepository.exists(codigo)) {
			usuarioRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/usuario", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {

		if (usuario != null) {
			if (!usuarioRepository.exists(usuario.getCodigo())) {
				return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
			}

			try {
				usuarioRepository.saveAndFlush(usuario);
			} catch (Exception e) {
				return new ResponseEntity<Usuario>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

}
