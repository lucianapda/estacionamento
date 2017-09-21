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

import br.com.estacionamento.model.Pais;
import br.com.estacionamento.model.PaisRepository;

@RestController
public class PaisController {

	@Inject
	private PaisRepository paisRepository;

	@RequestMapping(path = "/pais", method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Pais> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = paisRepository.obtemPeloNome(nome);
		} else {
			if (paisRepository.exists(codigo)) {
				Pais pais = paisRepository.findOne(codigo);
				listaRetorno.add(pais);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Pais>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Pais>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
