package br.com.zup.edu.umparamuitos1financeiro.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.zup.edu.umparamuitos1financeiro.model.Contato;
import br.com.zup.edu.umparamuitos1financeiro.model.Telefone;

public class ContatoDTO {
	
	@NotBlank
	private String nome;
	private String empresa;
	
	@Valid
	@NotEmpty
	private List<TelefoneDTO> telefones;

	public ContatoDTO(String nome, String empresa, List<TelefoneDTO> telefones) {
		this.nome = nome;
		this.empresa = empresa;
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public Contato toModel() {
		
		Contato contato = new Contato(nome, empresa);
		telefones.forEach(t -> {
			contato.adiciona(t.toModel());
			
		});
		
		return contato;
	}

}
