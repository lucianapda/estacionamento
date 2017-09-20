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

import br.com.estacionamento.model.Bairro;
import br.com.estacionamento.model.BairroRepository;

@RestController
public class BairroController {

	@Inject
	private BairroRepository bairroRepository;
	
	@RequestMapping(path = "/bairro", method = RequestMethod.GET)
	public ResponseEntity<List<Bairro>> getUsuarioNome(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Bairro> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = bairroRepository.obtemPeloNome(nome);
		} else {
			if (bairroRepository.exists(codigo)) {
				Bairro bairro = bairroRepository.findOne(codigo);
				listaRetorno.add(bairro);
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Bairro>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Bairro>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/bairro", method = RequestMethod.POST)
	public ResponseEntity<Bairro> saveEstacionamento(@RequestBody Bairro bairro) {

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
	public ResponseEntity<String> deleteEstacionamento(@RequestParam(name = "codigo", required=true) Long codigo) {
		
		if (bairroRepository.exists(codigo)) {
			bairroRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/bairro", method = RequestMethod.PUT)
	public ResponseEntity<Bairro> updateUsuario(@RequestBody Bairro bairro) {

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
