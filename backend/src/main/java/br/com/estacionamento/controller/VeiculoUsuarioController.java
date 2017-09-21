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

import br.com.estacionamento.model.VeiculoUsuario;
import br.com.estacionamento.model.VeiculoUsuarioRepository;

@RestController
public class VeiculoUsuarioController {

	@Inject
	private VeiculoUsuarioRepository veiculoUsuarioRepository;

	@RequestMapping(path = "/veiculoUsuario", method = RequestMethod.GET)
	public ResponseEntity<List<VeiculoUsuario>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<VeiculoUsuario> listaRetorno = new ArrayList<>();

		if (veiculoUsuarioRepository.exists(codigo)) {
			VeiculoUsuario veiculo = veiculoUsuarioRepository.findOne(codigo);
			listaRetorno.add(veiculo);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<VeiculoUsuario>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<VeiculoUsuario>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/veiculoUsuario", method = RequestMethod.POST)
	public ResponseEntity<VeiculoUsuario> save(@RequestBody VeiculoUsuario veiculo) {

		if (veiculo != null) {
			try {
				veiculoUsuarioRepository.saveAndFlush(veiculo);
			} catch (Exception e) {
				return new ResponseEntity<VeiculoUsuario>(veiculo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<VeiculoUsuario>(veiculo, HttpStatus.OK);
	}

	@RequestMapping(path = "/veiculoUsuario", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (veiculoUsuarioRepository.exists(codigo)) {
			veiculoUsuarioRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/veiculoUsuario", method = RequestMethod.PUT)
	public ResponseEntity<VeiculoUsuario> update(@RequestBody VeiculoUsuario veiculo) {

		if (veiculo != null) {
			if (!veiculoUsuarioRepository.exists(veiculo.getCodigo())) {
				return new ResponseEntity<VeiculoUsuario>(veiculo, HttpStatus.NOT_FOUND);
			}

			try {
				veiculoUsuarioRepository.saveAndFlush(veiculo);
			} catch (Exception e) {
				return new ResponseEntity<VeiculoUsuario>(veiculo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<VeiculoUsuario>(veiculo, HttpStatus.OK);
	}
}
