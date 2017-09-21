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

import br.com.estacionamento.model.Propaganda;
import br.com.estacionamento.model.PropagandaRepository;

@RestController
public class PropagandaController {

	@Inject
	private PropagandaRepository propagandaRepository;

	@RequestMapping(path = "/propaganda", method = RequestMethod.GET)
	public ResponseEntity<List<Propaganda>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Propaganda> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = propagandaRepository.obtemPeloNome(nome);
		} else {
			if (propagandaRepository.exists(codigo)) {
				Propaganda propaganda = propagandaRepository.findOne(codigo);
				listaRetorno.add(propaganda);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Propaganda>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Propaganda>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/propaganda", method = RequestMethod.POST)
	public ResponseEntity<Propaganda> save(@RequestBody Propaganda propaganda) {

		if (propaganda != null) {
			try {
				propagandaRepository.saveAndFlush(propaganda);
			} catch (Exception e) {
				return new ResponseEntity<Propaganda>(propaganda, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Propaganda>(propaganda, HttpStatus.OK);
	}

	@RequestMapping(path = "/propaganda", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (propagandaRepository.exists(codigo)) {
			propagandaRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/propaganda", method = RequestMethod.PUT)
	public ResponseEntity<Propaganda> update(@RequestBody Propaganda propaganda) {

		if (propaganda != null) {
			if (!propagandaRepository.exists(propaganda.getCodigo())) {
				return new ResponseEntity<Propaganda>(propaganda, HttpStatus.NOT_FOUND);
			}

			try {
				propagandaRepository.saveAndFlush(propaganda);
			} catch (Exception e) {
				return new ResponseEntity<Propaganda>(propaganda, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Propaganda>(propaganda, HttpStatus.OK);
	}
}
