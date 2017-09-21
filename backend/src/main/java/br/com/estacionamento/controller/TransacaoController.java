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

import br.com.estacionamento.model.Transacao;
import br.com.estacionamento.model.TransacaoRepository;

@RestController
public class TransacaoController {

	@Inject
	private TransacaoRepository transacaoRepository;
	
	@RequestMapping(path = "/transacao", method = RequestMethod.GET)
	public ResponseEntity<List<Transacao>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Transacao> listaRetorno = new ArrayList<>();

			if (transacaoRepository.exists(codigo)) {
				Transacao transacao = transacaoRepository.findOne(codigo);
				listaRetorno.add(transacao);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Transacao>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Transacao>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/transacao", method = RequestMethod.POST)
	public ResponseEntity<Transacao> save(@RequestBody Transacao transacao) {

		if (transacao != null) {
			try {
				transacaoRepository.saveAndFlush(transacao);
			} catch (Exception e) {
				return new ResponseEntity<Transacao>(transacao, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
	}

	@RequestMapping(path = "/transacao", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required=true) Long codigo) {
		
		if (transacaoRepository.exists(codigo)) {
			transacaoRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/transacao", method = RequestMethod.PUT)
	public ResponseEntity<Transacao> update(@RequestBody Transacao transacao) {

		if (transacao != null) {
			if (!transacaoRepository.exists(transacao.getCodigo())) {
				return new ResponseEntity<Transacao>(transacao, HttpStatus.NOT_FOUND);
			}

			try {
				transacaoRepository.saveAndFlush(transacao);
			} catch (Exception e) {
				return new ResponseEntity<Transacao>(transacao, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Transacao>(transacao, HttpStatus.OK);
	}
}
