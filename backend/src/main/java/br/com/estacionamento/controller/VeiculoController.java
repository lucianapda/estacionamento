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

import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.model.VeiculoRepository;

@RestController
public class VeiculoController {

	@Inject
	private VeiculoRepository veiculoRepository;
	
	@RequestMapping(path = "/veiculo", method = RequestMethod.GET)
	public ResponseEntity<List<Veiculo>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Veiculo> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = veiculoRepository.obtemPeloNome(nome);
		} else {
			if (veiculoRepository.exists(codigo)) {
				Veiculo veiculo = veiculoRepository.findOne(codigo);
				listaRetorno.add(veiculo);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Veiculo>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Veiculo>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/veiculo", method = RequestMethod.POST)
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {

		if (veiculo != null) {
			try {
				veiculoRepository.saveAndFlush(veiculo);
			} catch (Exception e) {
				return new ResponseEntity<Veiculo>(veiculo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}

	@RequestMapping(path = "/veiculo", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required=true) Long codigo) {
		
		if (veiculoRepository.exists(codigo)) {
			veiculoRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/veiculo", method = RequestMethod.PUT)
	public ResponseEntity<Veiculo> update(@RequestBody Veiculo veiculo) {

		if (veiculo != null) {
			if (!veiculoRepository.exists(veiculo.getCodigo())) {
				return new ResponseEntity<Veiculo>(veiculo, HttpStatus.NOT_FOUND);
			}

			try {
				veiculoRepository.saveAndFlush(veiculo);
			} catch (Exception e) {
				return new ResponseEntity<Veiculo>(veiculo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
}
