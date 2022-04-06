package br.com.zup.edu.umparamuitos1financeiro.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.zup.edu.umparamuitos1financeiro.model.Telefone;

public class TelefoneDTO {
	
	@NotBlank
	private String tipo;
	
	@Pattern(regexp = "^\\+[1-9][0-9]{2,15}$")
	@NotBlank
	private String numero;
	
	public TelefoneDTO(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public Telefone toModel() {
		return new Telefone(tipo, numero);
	}
	
}
