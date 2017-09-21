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

import br.com.estacionamento.model.Plano;
import br.com.estacionamento.model.PlanoRepository;

@RestController
public class PlanoController {

	@Inject
	private PlanoRepository planoRepository;

	@RequestMapping(path = "/plano", method = RequestMethod.GET)
	public ResponseEntity<List<Plano>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Plano> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = planoRepository.obtemPeloNome(nome);
		} else {
			if (planoRepository.exists(codigo)) {
				Plano plano = planoRepository.findOne(codigo);
				listaRetorno.add(plano);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Plano>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Plano>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/plano", method = RequestMethod.POST)
	public ResponseEntity<Plano> save(@RequestBody Plano plano) {

		if (plano != null) {
			try {
				planoRepository.saveAndFlush(plano);
			} catch (Exception e) {
				return new ResponseEntity<Plano>(plano, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Plano>(plano, HttpStatus.OK);
	}

	@RequestMapping(path = "/plano", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (planoRepository.exists(codigo)) {
			planoRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/plano", method = RequestMethod.PUT)
	public ResponseEntity<Plano> update(@RequestBody Plano plano) {

		if (plano != null) {
			if (!planoRepository.exists(plano.getCodigo())) {
				return new ResponseEntity<Plano>(plano, HttpStatus.NOT_FOUND);
			}

			try {
				planoRepository.saveAndFlush(plano);
			} catch (Exception e) {
				return new ResponseEntity<Plano>(plano, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Plano>(plano, HttpStatus.OK);
	}
}
