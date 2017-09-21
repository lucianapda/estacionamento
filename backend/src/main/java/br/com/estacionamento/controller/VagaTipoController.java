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

import br.com.estacionamento.model.VagaTipo;
import br.com.estacionamento.model.VagaTipoRepository;

@RestController
public class VagaTipoController {

	@Inject
	private VagaTipoRepository vagaTipoRepository;

	@RequestMapping(path = "/vagaTipo", method = RequestMethod.GET)
	public ResponseEntity<List<VagaTipo>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<VagaTipo> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = vagaTipoRepository.obtemPeloNome(nome);
		} else {
			if (vagaTipoRepository.exists(codigo)) {
				VagaTipo vagaTipo = vagaTipoRepository.findOne(codigo);
				listaRetorno.add(vagaTipo);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<VagaTipo>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<VagaTipo>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
