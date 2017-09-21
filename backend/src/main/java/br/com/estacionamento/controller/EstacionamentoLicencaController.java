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

import br.com.estacionamento.model.EstacionamentoLicenca;
import br.com.estacionamento.model.EstacionamentoLicencaRepository;

@RestController
public class EstacionamentoLicencaController {

	@Inject
	private EstacionamentoLicencaRepository estacionamentoLicencaRepository;

	@RequestMapping(path = "/licenca", method = RequestMethod.GET)
	public ResponseEntity<List<EstacionamentoLicenca>> get(
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<EstacionamentoLicenca> listaRetorno = new ArrayList<>();

		if (estacionamentoLicencaRepository.exists(codigo)) {
			EstacionamentoLicenca licenca = estacionamentoLicencaRepository.findOne(codigo);
			listaRetorno.add(licenca);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<EstacionamentoLicenca>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<EstacionamentoLicenca>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/licenca", method = RequestMethod.POST)
	public ResponseEntity<EstacionamentoLicenca> save(@RequestBody EstacionamentoLicenca licenca) {

		if (licenca != null) {
			try {
				estacionamentoLicencaRepository.saveAndFlush(licenca);
			} catch (Exception e) {
				return new ResponseEntity<EstacionamentoLicenca>(licenca, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<EstacionamentoLicenca>(licenca, HttpStatus.OK);
	}

	@RequestMapping(path = "/licenca", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (estacionamentoLicencaRepository.exists(codigo)) {
			estacionamentoLicencaRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/licenca", method = RequestMethod.PUT)
	public ResponseEntity<EstacionamentoLicenca> update(@RequestBody EstacionamentoLicenca licenca) {

		if (licenca != null) {
			if (!estacionamentoLicencaRepository.exists(licenca.getCodigo())) {
				return new ResponseEntity<EstacionamentoLicenca>(licenca, HttpStatus.NOT_FOUND);
			}

			try {
				estacionamentoLicencaRepository.saveAndFlush(licenca);
			} catch (Exception e) {
				return new ResponseEntity<EstacionamentoLicenca>(licenca, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<EstacionamentoLicenca>(licenca, HttpStatus.OK);
	}
}
