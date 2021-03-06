package br.com.estacionamento.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.model.Bairro;
import br.com.estacionamento.model.BairroRepository;

@RestController
public class BairroController {

	@Inject
	private BairroRepository bairroRepository;

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/bairro", method = RequestMethod.GET)
	public ResponseEntity<List<Bairro>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo,
			@RequestParam(name = "codigoCidade", required = false) Long codigoCidade) {
		List<Bairro> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = bairroRepository.obtemPeloNome(nome);
		} else {
			if(codigo != null) {
				if (bairroRepository.exists(codigo)) {
					Bairro bairro = bairroRepository.findOne(codigo);
					listaRetorno.add(bairro);
				}
			}else {
				if(codigoCidade != null) {
					listaRetorno = bairroRepository.obtemPelaCidade(codigoCidade);
				}else {
					listaRetorno = bairroRepository.obtemTodos();
				}
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Bairro>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Bairro>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/bairro", method = RequestMethod.POST)
	public ResponseEntity<Bairro> save(@RequestBody Bairro bairro) {

		if (bairro != null) {
			try {
				bairroRepository.saveAndFlush(bairro);
			} catch (Exception e) {
				return new ResponseEntity<Bairro>(bairro, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Bairro>(bairro, HttpStatus.OK);
	}

	@RequestMapping(path = "/bairro", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required=true) Long codigo) {

		if (bairroRepository.exists(codigo)) {
			bairroRepository.delete(codigo);
			return new ResponseEntity<String>("Exclu�do com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/bairro", method = RequestMethod.PUT)
	public ResponseEntity<Bairro> update(@RequestBody Bairro bairro) {

		if (bairro != null) {
			if (!bairroRepository.exists(bairro.getCodigo())) {
				return new ResponseEntity<Bairro>(bairro, HttpStatus.NOT_FOUND);
			}

			try {
				bairroRepository.saveAndFlush(bairro);
			} catch (Exception e) {
				return new ResponseEntity<Bairro>(bairro, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Bairro>(bairro, HttpStatus.OK);
	}
}
