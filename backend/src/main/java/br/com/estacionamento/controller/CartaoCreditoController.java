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

import br.com.estacionamento.model.CartaoCredito;
import br.com.estacionamento.model.CartaoCreditoRepository;

@RestController
public class CartaoCreditoController {

	@Inject
	private CartaoCreditoRepository cartaoCreditoRepository;

	@RequestMapping(path = "/cartaoCredito", method = RequestMethod.GET)
	public ResponseEntity<List<CartaoCredito>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<CartaoCredito> listaRetorno = new ArrayList<>();

		if (cartaoCreditoRepository.exists(codigo)) {
			CartaoCredito cartaoCredito = cartaoCreditoRepository.findOne(codigo);
			listaRetorno.add(cartaoCredito);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<CartaoCredito>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<CartaoCredito>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/cartaoCredito", method = RequestMethod.POST)
	public ResponseEntity<CartaoCredito> save(@RequestBody CartaoCredito cartaoCredito) {

		if (cartaoCredito != null) {
			try {
				cartaoCreditoRepository.saveAndFlush(cartaoCredito);
			} catch (Exception e) {
				return new ResponseEntity<CartaoCredito>(cartaoCredito, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<CartaoCredito>(cartaoCredito, HttpStatus.OK);
	}

	@RequestMapping(path = "/cartaoCredito", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (cartaoCreditoRepository.exists(codigo)) {
			cartaoCreditoRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/cartaoCredito", method = RequestMethod.PUT)
	public ResponseEntity<CartaoCredito> update(@RequestBody CartaoCredito carcaoCredito) {

		if (carcaoCredito != null) {
			if (!cartaoCreditoRepository.exists(carcaoCredito.getCodigo())) {
				return new ResponseEntity<CartaoCredito>(carcaoCredito, HttpStatus.NOT_FOUND);
			}

			try {
				cartaoCreditoRepository.saveAndFlush(carcaoCredito);
			} catch (Exception e) {
				return new ResponseEntity<CartaoCredito>(carcaoCredito, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<CartaoCredito>(carcaoCredito, HttpStatus.OK);
	}
}
