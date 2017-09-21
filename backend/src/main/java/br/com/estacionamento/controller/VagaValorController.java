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

import br.com.estacionamento.model.VagaValor;
import br.com.estacionamento.model.VagaValorRepository;

@RestController
public class VagaValorController {

	@Inject
	private VagaValorRepository vagaValorRepository;
	
	@RequestMapping(path = "/vagaValor", method = RequestMethod.GET)
	public ResponseEntity<List<VagaValor>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<VagaValor> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = vagaValorRepository.obtemPeloNome(nome);
		} else {
			if (vagaValorRepository.exists(codigo)) {
				VagaValor vagavalor = vagaValorRepository.findOne(codigo);
				listaRetorno.add(vagavalor);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<VagaValor>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<VagaValor>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/vagaValor", method = RequestMethod.POST)
	public ResponseEntity<VagaValor> save(@RequestBody VagaValor vaga) {

		if (vaga != null) {
			try {
				vagaValorRepository.saveAndFlush(vaga);
			} catch (Exception e) {
				return new ResponseEntity<VagaValor>(vaga, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<VagaValor>(vaga, HttpStatus.OK);
	}

	@RequestMapping(path = "/vagaValor", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required=true) Long codigo) {
		
		if (vagaValorRepository.exists(codigo)) {
			vagaValorRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/vagaValor", method = RequestMethod.PUT)
	public ResponseEntity<VagaValor> update(@RequestBody VagaValor vaga) {

		if (vaga != null) {
			if (!vagaValorRepository.exists(vaga.getCodigo())) {
				return new ResponseEntity<VagaValor>(vaga, HttpStatus.NOT_FOUND);
			}

			try {
				vagaValorRepository.saveAndFlush(vaga);
			} catch (Exception e) {
				return new ResponseEntity<VagaValor>(vaga, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<VagaValor>(vaga, HttpStatus.OK);
	}
}
