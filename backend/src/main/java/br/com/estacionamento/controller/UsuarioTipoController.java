package br.com.estacionamento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.model.UsuarioTipo;
import br.com.estacionamento.model.UsuarioTipoRepository;

@RestController
public class UsuarioTipoController {

	@Inject
	private UsuarioTipoRepository usuarioTipoRepository;

	@RequestMapping(path = "/usuarioTipo", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioTipo>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<UsuarioTipo> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = usuarioTipoRepository.obtemPeloNome(nome);
		} else {
			if (usuarioTipoRepository.exists(codigo)) {
				UsuarioTipo usuarioTipo = usuarioTipoRepository.findOne(codigo);
				listaRetorno.add(usuarioTipo);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<UsuarioTipo>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<UsuarioTipo>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
