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

import br.com.estacionamento.model.Reserva;
import br.com.estacionamento.model.ReservaRepository;

@RestController
public class ReservaController {

	@Inject
	private ReservaRepository reservaRepository;

	@RequestMapping(path = "/reserva", method = RequestMethod.GET)
	public ResponseEntity<List<Reserva>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Reserva> listaRetorno = new ArrayList<>();

		if (reservaRepository.exists(codigo)) {
			Reserva reserva = reservaRepository.findOne(codigo);
			listaRetorno.add(reserva);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Reserva>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Reserva>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/reserva", method = RequestMethod.POST)
	public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {

		if (reserva != null) {
			try {
				reservaRepository.saveAndFlush(reserva);
			} catch (Exception e) {
				return new ResponseEntity<Reserva>(reserva, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}

	@RequestMapping(path = "/reserva", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (reservaRepository.exists(codigo)) {
			reservaRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/reserva", method = RequestMethod.PUT)
	public ResponseEntity<Reserva> update(@RequestBody Reserva reserva) {

		if (reserva != null) {
			if (!reservaRepository.exists(reserva.getCodigo())) {
				return new ResponseEntity<Reserva>(reserva, HttpStatus.NOT_FOUND);
			}

			try {
				reservaRepository.saveAndFlush(reserva);
			} catch (Exception e) {
				return new ResponseEntity<Reserva>(reserva, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
	}
}
