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

import br.com.estacionamento.model.VagaStatus;
import br.com.estacionamento.model.VagaStatusRepository;

@RestController
public class VagaStatusController {

	@Inject
	private VagaStatusRepository vagaStatusRepository;

	@RequestMapping(path = "/vagaStatus", method = RequestMethod.GET)
	public ResponseEntity<List<VagaStatus>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<VagaStatus> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = vagaStatusRepository.obtemPeloNome(nome);
		} else {
			if (vagaStatusRepository.exists(codigo)) {
				VagaStatus vaga = vagaStatusRepository.findOne(codigo);
				listaRetorno.add(vaga);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<VagaStatus>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<VagaStatus>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
