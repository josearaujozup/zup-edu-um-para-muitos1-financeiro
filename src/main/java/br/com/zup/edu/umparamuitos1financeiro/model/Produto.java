package br.com.zup.edu.umparamuitos1financeiro.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nome;
	private BigDecimal valor;
	
	public Produto(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto(Long id) {
		this.id = id;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public Produto() {
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
    
}
