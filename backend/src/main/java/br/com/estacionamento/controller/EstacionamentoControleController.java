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

import br.com.estacionamento.model.EstacionamentoControle;
import br.com.estacionamento.model.EstacionamentoControleRepository;

@RestController
public class EstacionamentoControleController {

	@Inject
	private EstacionamentoControleRepository estacionamentoControleRepository;

	@RequestMapping(path = "/estacionamentoControle", method = RequestMethod.GET)
	public ResponseEntity<List<EstacionamentoControle>> get(
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<EstacionamentoControle> listaRetorno = new ArrayList<>();

		if (estacionamentoControleRepository.exists(codigo)) {
			EstacionamentoControle estacionamentoControle = estacionamentoControleRepository.findOne(codigo);
			listaRetorno.add(estacionamentoControle);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<EstacionamentoControle>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<EstacionamentoControle>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/estacionamentoControle", method = RequestMethod.POST)
	public ResponseEntity<EstacionamentoControle> save(@RequestBody EstacionamentoControle estacionamentoControle) {

		if (estacionamentoControle != null) {
			try {
				estacionamentoControleRepository.saveAndFlush(estacionamentoControle);
			} catch (Exception e) {
				return new ResponseEntity<EstacionamentoControle>(estacionamentoControle,
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<EstacionamentoControle>(estacionamentoControle, HttpStatus.OK);
	}

	@RequestMapping(path = "/estacionamentoControle", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (estacionamentoControleRepository.exists(codigo)) {
			estacionamentoControleRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/estacionamentoControle", method = RequestMethod.PUT)
	public ResponseEntity<EstacionamentoControle> update(@RequestBody EstacionamentoControle estacionamentoControle) {

		if (estacionamentoControle != null) {
			if (!estacionamentoControleRepository.exists(estacionamentoControle.getCodigo())) {
				return new ResponseEntity<EstacionamentoControle>(estacionamentoControle, HttpStatus.NOT_FOUND);
			}

			try {
				estacionamentoControleRepository.saveAndFlush(estacionamentoControle);
			} catch (Exception e) {
				return new ResponseEntity<EstacionamentoControle>(estacionamentoControle,
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<EstacionamentoControle>(estacionamentoControle, HttpStatus.OK);
	}
}
