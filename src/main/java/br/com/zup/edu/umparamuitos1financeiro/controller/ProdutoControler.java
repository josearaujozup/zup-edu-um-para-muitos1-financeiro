package br.com.zup.edu.umparamuitos1financeiro.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos1financeiro.model.Produto;
import br.com.zup.edu.umparamuitos1financeiro.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControler {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional
	@PostMapping
	public ResponseEntity<?> cadastra(@RequestBody @Valid ProdutoDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Produto novoProduto = request.toModel();
		repository.save(novoProduto);
		
		URI location = uriComponentsBuilder.path("/api/produtos/{id}").buildAndExpand(novoProduto.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
