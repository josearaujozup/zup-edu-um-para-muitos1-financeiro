package br.com.zup.edu.umparamuitos1financeiro.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.umparamuitos1financeiro.model.Item;
import br.com.zup.edu.umparamuitos1financeiro.model.Produto;

public class ItemDTO {
	
	@NotNull
	private Long produtoId;
	
	@NotNull
	@Positive
	private Integer quantidade;
	
	public ItemDTO(Long produtoId, Integer quantidade) {
		super();
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Item toModel() {
		return new Item(new Produto(produtoId), quantidade);
	}
	
}
