package br.com.sensorsus.sensorsus.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sensorsus.sensorsus.dto.EstabelecimentoAvaliacaoDTO;
import br.com.sensorsus.sensorsus.dto.EstabelecimentoDTO;
import br.com.sensorsus.sensorsus.model.Estabelecimento;
import br.com.sensorsus.sensorsus.services.EstabelecimentoService;

@RestController
@RequestMapping(value="/estabelecimentos")
public class EstabelecimentoResource {
	
	@Autowired
	private EstabelecimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Estabelecimento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//**listando todos estabelecimentos e suas respectivas avaliacões  com DTO - EndPoint '/estabelecimento/avaliacoes'*/
	@RequestMapping(value="/avaliacoes", method=RequestMethod.GET)
	public ResponseEntity<List<EstabelecimentoAvaliacaoDTO>> findAvaliacao() {
		List<Estabelecimento> list = service.findAll();
		List<EstabelecimentoAvaliacaoDTO> listAvalicaoDto = list.stream().map(obj -> new EstabelecimentoAvaliacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listAvalicaoDto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstabelecimentoDTO>> findAll() {
		List<Estabelecimento> list = service.findAll();
		List<EstabelecimentoDTO> listDto = list.stream().map(obj -> new EstabelecimentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
}