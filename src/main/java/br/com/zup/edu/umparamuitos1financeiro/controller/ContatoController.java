package br.com.zup.edu.umparamuitos1financeiro.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos1financeiro.model.Contato;
import br.com.zup.edu.umparamuitos1financeiro.repository.ContatoRepository;

@RestController
public class ContatoController {
	
	@Autowired
	private ContatoRepository repository;
	
	@Transactional
	@PostMapping("/api/contatos")
	public ResponseEntity<?> cadastra(@RequestBody @Valid ContatoDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Contato contato = request.toModel();
		repository.save(contato);
		
		URI location = uriComponentsBuilder.path("/api/contatos/{id}").buildAndExpand(contato.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
