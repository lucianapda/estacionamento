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

import br.com.estacionamento.model.Vaga;
import br.com.estacionamento.model.VagaRepository;

@RestController
public class VagaController {

	@Inject
	private VagaRepository vagaRepository;

	@RequestMapping(path = "/vaga", method = RequestMethod.GET)
	public ResponseEntity<List<Vaga>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Vaga> listaRetorno = new ArrayList<>();

		if (vagaRepository.exists(codigo)) {
			Vaga vaga = vagaRepository.findOne(codigo);
			listaRetorno.add(vaga);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Vaga>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Vaga>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/vaga", method = RequestMethod.POST)
	public ResponseEntity<Vaga> save(@RequestBody Vaga vaga) {

		if (vaga != null) {
			try {
				vagaRepository.saveAndFlush(vaga);
			} catch (Exception e) {
				return new ResponseEntity<Vaga>(vaga, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Vaga>(vaga, HttpStatus.OK);
	}

	@RequestMapping(path = "/vaga", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (vagaRepository.exists(codigo)) {
			vagaRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/vaga", method = RequestMethod.PUT)
	public ResponseEntity<Vaga> update(@RequestBody Vaga vaga) {

		if (vaga != null) {
			if (!vagaRepository.exists(vaga.getCodigo())) {
				return new ResponseEntity<Vaga>(vaga, HttpStatus.NOT_FOUND);
			}

			try {
				vagaRepository.saveAndFlush(vaga);
			} catch (Exception e) {
				return new ResponseEntity<Vaga>(vaga, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Vaga>(vaga, HttpStatus.OK);
	}
}
