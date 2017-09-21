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

import br.com.estacionamento.model.Localidade;
import br.com.estacionamento.model.LocalidadeRepository;

@RestController
public class LocalidadeController {

	@Inject
	private LocalidadeRepository localidadeRepository;

	@RequestMapping(path = "/localidade", method = RequestMethod.GET)
	public ResponseEntity<List<Localidade>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Localidade> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = localidadeRepository.obtemPeloNome(nome);
		} else {
			if (localidadeRepository.exists(codigo)) {
				Localidade localidade = localidadeRepository.findOne(codigo);
				listaRetorno.add(localidade);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Localidade>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Localidade>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/localidade", method = RequestMethod.POST)
	public ResponseEntity<Localidade> save(@RequestBody Localidade localidade) {

		if (localidade != null) {
			try {
				localidadeRepository.saveAndFlush(localidade);
			} catch (Exception e) {
				return new ResponseEntity<Localidade>(localidade, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Localidade>(localidade, HttpStatus.OK);
	}

	@RequestMapping(path = "/localidade", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (localidadeRepository.exists(codigo)) {
			localidadeRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/localidade", method = RequestMethod.PUT)
	public ResponseEntity<Localidade> update(@RequestBody Localidade localidade) {

		if (localidade != null) {
			if (!localidadeRepository.exists(localidade.getCodigo())) {
				return new ResponseEntity<Localidade>(localidade, HttpStatus.NOT_FOUND);
			}

			try {
				localidadeRepository.saveAndFlush(localidade);
			} catch (Exception e) {
				return new ResponseEntity<Localidade>(localidade, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Localidade>(localidade, HttpStatus.OK);
	}
}
