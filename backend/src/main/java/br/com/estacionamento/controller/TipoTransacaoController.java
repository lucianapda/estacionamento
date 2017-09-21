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

import br.com.estacionamento.model.TipoTransacao;
import br.com.estacionamento.model.TipoTransacaoRepository;

@RestController
public class TipoTransacaoController {

	@Inject
	private TipoTransacaoRepository tipoTransacaoRepository;

	@RequestMapping(path = "/tipoTransacao", method = RequestMethod.GET)
	public ResponseEntity<List<TipoTransacao>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<TipoTransacao> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = tipoTransacaoRepository.obtemPeloNome(nome);
		} else {
			if (tipoTransacaoRepository.exists(codigo)) {
				TipoTransacao tipoTransacao = tipoTransacaoRepository.findOne(codigo);
				listaRetorno.add(tipoTransacao);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<TipoTransacao>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<TipoTransacao>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
