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

import br.com.estacionamento.model.Estacionamento;
import br.com.estacionamento.model.EstacionamentoRepository;

@RestController
public class EstacionamentoController {

	@Inject
	private EstacionamentoRepository estacionamentoRepository;
	
	@RequestMapping(path = "/estacionamento", method = RequestMethod.GET)
	public ResponseEntity<List<Estacionamento>> getUsuarioNome(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Estacionamento> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = estacionamentoRepository.obtemPeloNome(nome);
		} else {
			if (estacionamentoRepository.exists(codigo)) {
				Estacionamento estacionamento = estacionamentoRepository.findOne(codigo);
				listaRetorno.add(estacionamento);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Estacionamento>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Estacionamento>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/estacionamento", method = RequestMethod.POST)
	public ResponseEntity<Estacionamento> saveEstacionamento(@RequestBody Estacionamento estacionamento) {

		if (estacionamento != null) {
			try {
				estacionamentoRepository.saveAndFlush(estacionamento);
			} catch (Exception e) {
				return new ResponseEntity<Estacionamento>(estacionamento, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Estacionamento>(estacionamento, HttpStatus.OK);
	}

	@RequestMapping(path = "/estacionamento", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEstacionamento(@RequestParam(name = "codigo", required=true) Long codigo) {
		
		if (estacionamentoRepository.exists(codigo)) {
			estacionamentoRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/estacionamento", method = RequestMethod.PUT)
	public ResponseEntity<Estacionamento> updateUsuario(@RequestBody Estacionamento estacionamento) {

		if (estacionamento != null) {
			if (!estacionamentoRepository.exists(estacionamento.getCodigo())) {
				return new ResponseEntity<Estacionamento>(estacionamento, HttpStatus.NOT_FOUND);
			}

			try {
				estacionamentoRepository.saveAndFlush(estacionamento);
			} catch (Exception e) {
				return new ResponseEntity<Estacionamento>(estacionamento, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Estacionamento>(estacionamento, HttpStatus.OK);
	}
}
