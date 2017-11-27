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

import br.com.estacionamento.model.UsuarioImg;
import br.com.estacionamento.model.UsuarioImgRepository;

@RestController
public class UsuarioImgController {

	@Inject
	private UsuarioImgRepository usuarioImgRepository;

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/usuarioimg", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioImg>> get(@RequestParam(name = "codigo", required = true) Long codigo) {
		List<UsuarioImg> listaRetorno = new ArrayList<>();

		if (codigo != null) {
			UsuarioImg usuarioImg = usuarioImgRepository.obtemPeloCodigoUsu(codigo);
			listaRetorno.add(usuarioImg);
		} else {
			if (codigo == null) {
				listaRetorno = usuarioImgRepository.findAll();
			}
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<UsuarioImg>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<UsuarioImg>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/usuarioimg", method = RequestMethod.POST)
	public ResponseEntity<UsuarioImg> save(@RequestBody UsuarioImg usuarioImg) {

		if (usuarioImg != null) {
			try {
				usuarioImgRepository.saveAndFlush(usuarioImg);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<UsuarioImg>(usuarioImg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<UsuarioImg>(usuarioImg, HttpStatus.OK);
	}

	@RequestMapping(path = "/usuarioimg", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (usuarioImgRepository.exists(codigo)) {
			usuarioImgRepository.delete(codigo);
			usuarioImgRepository.flush();
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/usuarioimg", method = RequestMethod.PUT)
	public ResponseEntity<UsuarioImg> update(@RequestBody UsuarioImg usuarioImg) {

		if (usuarioImg != null) {
			if (!usuarioImgRepository.exists(usuarioImg.getCodigo())) {
				return new ResponseEntity<UsuarioImg>(usuarioImg, HttpStatus.NOT_FOUND);
			}

			try {
				usuarioImgRepository.saveAndFlush(usuarioImg);
			} catch (Exception e) {
				return new ResponseEntity<UsuarioImg>(usuarioImg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<UsuarioImg>(usuarioImg, HttpStatus.OK);
	}
}
