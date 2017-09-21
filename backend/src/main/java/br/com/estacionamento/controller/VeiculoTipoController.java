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

import br.com.estacionamento.model.VeiculoTipo;
import br.com.estacionamento.model.VeiculoTipoRepository;

@RestController
public class VeiculoTipoController {

	@Inject
	private VeiculoTipoRepository veiculoTipoRepository;

	@RequestMapping(path = "/veiculoTipo", method = RequestMethod.GET)
	public ResponseEntity<List<VeiculoTipo>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<VeiculoTipo> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = veiculoTipoRepository.obtemPeloNome(nome);
		} else {
			if (veiculoTipoRepository.exists(codigo)) {
				VeiculoTipo veiculo = veiculoTipoRepository.findOne(codigo);
				listaRetorno.add(veiculo);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<VeiculoTipo>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<VeiculoTipo>>(listaRetorno, HttpStatus.NOT_FOUND);
	}
}
