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

import br.com.estacionamento.model.PropagandaEstacionamento;
import br.com.estacionamento.model.PropagandaEstacionamentoRepository;

@RestController
public class PropagandaEstacionamentoController {

	@Inject
	private PropagandaEstacionamentoRepository propagandaEstacionamentoRepository;

	@RequestMapping(path = "/propagandaEstacionamento", method = RequestMethod.GET)
	public ResponseEntity<List<PropagandaEstacionamento>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<PropagandaEstacionamento> listaRetorno = new ArrayList<>();

			if (propagandaEstacionamentoRepository.exists(codigo)) {
			PropagandaEstacionamento propagandaEstacionamento = propagandaEstacionamentoRepository.findOne(codigo);
				listaRetorno.add(propagandaEstacionamento);
			}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<PropagandaEstacionamento>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<PropagandaEstacionamento>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
