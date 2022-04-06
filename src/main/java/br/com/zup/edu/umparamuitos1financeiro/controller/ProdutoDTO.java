package br.com.zup.edu.umparamuitos1financeiro.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.umparamuitos1financeiro.model.Produto;

public class ProdutoDTO {
	
    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

	public ProdutoDTO(@NotBlank String nome, @NotNull @Positive BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}
    
	public ProdutoDTO() {
		
	}
	
	public Produto toModel() {
		return new Produto(nome, valor);
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	
}
