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

import br.com.estacionamento.model.FormaPagamento;
import br.com.estacionamento.model.FormaPagamentoRepository;

@RestController
public class FormaPagamentoController {

	@Inject
	private FormaPagamentoRepository formaPagamentoRepository;

	@RequestMapping(path = "/formapagamento", method = RequestMethod.GET)
	public ResponseEntity<List<FormaPagamento>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<FormaPagamento> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = formaPagamentoRepository.obtemPeloNome(nome);
		} else {
			if (formaPagamentoRepository.exists(codigo)) {
				FormaPagamento formaPagamento = formaPagamentoRepository.findOne(codigo);
				listaRetorno.add(formaPagamento);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<FormaPagamento>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<FormaPagamento>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
