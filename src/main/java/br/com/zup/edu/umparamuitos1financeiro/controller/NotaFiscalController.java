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

import br.com.zup.edu.umparamuitos1financeiro.model.NotaFiscal;
import br.com.zup.edu.umparamuitos1financeiro.repository.NotaFiscalRepository;

@RestController
public class NotaFiscalController {
	
	@Autowired
	private NotaFiscalRepository repository;
	
	@Transactional
	@PostMapping("/api/notas-fiscais")
	public ResponseEntity<?> cadastra(@RequestBody @Valid NotaFiscalDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		NotaFiscal notaFiscal = request.toModel();
		repository.save(notaFiscal);
		
		URI location = uriComponentsBuilder.path("/api/notas-fiscais/{id}").buildAndExpand(notaFiscal.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
