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

import br.com.estacionamento.model.Estacionamento_img;
import br.com.estacionamento.model.Estacionamento_imgRepository;

@RestController
public class Estacionamento_imgController {

	@Inject
	private Estacionamento_imgRepository estacionamentoimgRepository;

	@RequestMapping(path = "/estacionamentoimg", method = RequestMethod.GET)
	public ResponseEntity<List<Estacionamento_img>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Estacionamento_img> listaRetorno = new ArrayList<>();

		if (estacionamentoimgRepository.exists(codigo)) {
			Estacionamento_img estacionamentoImg = estacionamentoimgRepository.findOne(codigo);
			listaRetorno.add(estacionamentoImg);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Estacionamento_img>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Estacionamento_img>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/estacionamentoimg", method = RequestMethod.POST)
	public ResponseEntity<Estacionamento_img> save(@RequestBody Estacionamento_img estacionamentoImg) {

		if (estacionamentoImg != null) {
			try {
				estacionamentoimgRepository.saveAndFlush(estacionamentoImg);
			} catch (Exception e) {
				return new ResponseEntity<Estacionamento_img>(estacionamentoImg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Estacionamento_img>(estacionamentoImg, HttpStatus.OK);
	}

	@RequestMapping(path = "/estacionamentoimg", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (estacionamentoimgRepository.exists(codigo)) {
			estacionamentoimgRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/estacionamentoimg", method = RequestMethod.PUT)
	public ResponseEntity<Estacionamento_img> update(@RequestBody Estacionamento_img estacionamentoImg) {

		if (estacionamentoImg != null) {
			if (!estacionamentoimgRepository.exists(estacionamentoImg.getCodigo())) {
				return new ResponseEntity<Estacionamento_img>(estacionamentoImg, HttpStatus.NOT_FOUND);
			}

			try {
				estacionamentoimgRepository.saveAndFlush(estacionamentoImg);
			} catch (Exception e) {
				return new ResponseEntity<Estacionamento_img>(estacionamentoImg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Estacionamento_img>(estacionamentoImg, HttpStatus.OK);
	}
}
