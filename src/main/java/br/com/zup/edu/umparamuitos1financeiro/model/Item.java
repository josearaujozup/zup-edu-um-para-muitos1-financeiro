package br.com.zup.edu.umparamuitos1financeiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Produto produto;
	private Integer quantidade;
	
	public Item(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

}
