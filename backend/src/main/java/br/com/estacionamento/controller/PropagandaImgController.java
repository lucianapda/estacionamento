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

import br.com.estacionamento.model.PropagandaImg;
import br.com.estacionamento.model.PropagandaImgRepository;

@RestController
public class PropagandaImgController {

	@Inject
	private PropagandaImgRepository propagandaImgRepository;

	@RequestMapping(path = "/propagandaimg", method = RequestMethod.GET)
	public ResponseEntity<List<PropagandaImg>> get(@RequestParam(name = "codigo", required = false) Long codigo) {
		List<PropagandaImg> listaRetorno = new ArrayList<>();

		if (propagandaImgRepository.exists(codigo)) {
			PropagandaImg propagandaImg = propagandaImgRepository.findOne(codigo);
			listaRetorno.add(propagandaImg);
		}

		if (listaRetorno.size() > 0) {
			return new ResponseEntity<List<PropagandaImg>>(listaRetorno, HttpStatus.OK);
		}
		return new ResponseEntity<List<PropagandaImg>>(listaRetorno, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/propagandaimg", method = RequestMethod.POST)
	public ResponseEntity<PropagandaImg> save(@RequestBody PropagandaImg propagandaimg) {

		if (propagandaimg != null) {
			try {
				propagandaImgRepository.saveAndFlush(propagandaimg);
			} catch (Exception e) {
				return new ResponseEntity<PropagandaImg>(propagandaimg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<PropagandaImg>(propagandaimg, HttpStatus.OK);
	}

	@RequestMapping(path = "/propagandaimg", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "codigo", required = true) Long codigo) {

		if (propagandaImgRepository.exists(codigo)) {
			propagandaImgRepository.delete(codigo);
			return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Erro ao tentar excluir", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(path = "/propagandaimg", method = RequestMethod.PUT)
	public ResponseEntity<PropagandaImg> update(@RequestBody PropagandaImg propagandaImg) {

		if (propagandaImg != null) {
			if (!propagandaImgRepository.exists(propagandaImg.getCodigo())) {
				return new ResponseEntity<PropagandaImg>(propagandaImg, HttpStatus.NOT_FOUND);
			}

			try {
				propagandaImgRepository.saveAndFlush(propagandaImg);
			} catch (Exception e) {
				return new ResponseEntity<PropagandaImg>(propagandaImg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<PropagandaImg>(propagandaImg, HttpStatus.OK);
	}
}
