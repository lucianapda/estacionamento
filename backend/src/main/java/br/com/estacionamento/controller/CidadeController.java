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

import br.com.estacionamento.model.Cidade;
import br.com.estacionamento.model.CidadeRepository;

@RestController
public class CidadeController {

	@Inject
	private CidadeRepository cidadeRepository;

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/cidade", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> get(@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "codigo", required = false) Long codigo) {
		List<Cidade> listaRetorno = new ArrayList<>();

		if (nome != null && !nome.isEmpty()) {
			listaRetorno = cidadeRepository.obtemPeloNome(nome);
		} else {
			if(codigo != null) {
				if (cidadeRepository.exists(codigo)) {
					Cidade cidade = cidadeRepository.findOne(codigo);
					listaRetorno.add(cidade);
				}
			}else {
				listaRetorno = cidadeRepository.obtemTodos();
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<Cidade>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<Cidade>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/cidade", method = RequestMethod.POST)
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {

		if (cidade != null) {
			try {
				cidadeRepository.saveAndFlush(cidade);
			} catch (Exception e) {
				return new ResponseEntity<Cidade>(cidade, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
	}

	@RequestMapping(path = "/cidade", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (cidadeRepository.exists(codigo)) {
			cidadeRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/cidade", method = RequestMethod.PUT)
	public ResponseEntity<Cidade> update(@RequestBody Cidade cidade) {

		if (cidade != null) {
			if (!cidadeRepository.exists(cidade.getCodigo())) {
				return new ResponseEntity<Cidade>(cidade, HttpStatus.NOT_FOUND);
			}

			try {
				cidadeRepository.saveAndFlush(cidade);
			} catch (Exception e) {
				return new ResponseEntity<Cidade>(cidade, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
	}
}
