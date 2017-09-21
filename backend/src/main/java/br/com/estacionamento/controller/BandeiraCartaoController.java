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

import br.com.estacionamento.model.BandeiraCartao;
import br.com.estacionamento.model.BandeiraCartaoRepository;

@RestController
public class BandeiraCartaoController {

	@Inject
	private BandeiraCartaoRepository bandeiraCartaoRepository;
	
	@RequestMapping(path = "/bandeiraCartao", method = RequestMethod.GET)
	public ResponseEntity<List<BandeiraCartao>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<BandeiraCartao> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = bandeiraCartaoRepository.obtemPeloNome(nome);
		} else {
			if (bandeiraCartaoRepository.exists(codigo)) {
				BandeiraCartao bandeiraCartao = bandeiraCartaoRepository.findOne(codigo);
				listaRetorno.add(bandeiraCartao);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<BandeiraCartao>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<BandeiraCartao>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
