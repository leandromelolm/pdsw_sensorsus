package br.com.sensorsus.sensorsus.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sensorsus.sensorsus.model.AvaliacaoEstabelecimento;
import br.com.sensorsus.sensorsus.services.AvaliacaoEstabelecimentoService;

@RestController
@RequestMapping(value="/avaliacaoestabelecimentos")
public class AvaliacaoEstabelecimentoResource {
	
	@Autowired
	private AvaliacaoEstabelecimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AvaliacaoEstabelecimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
