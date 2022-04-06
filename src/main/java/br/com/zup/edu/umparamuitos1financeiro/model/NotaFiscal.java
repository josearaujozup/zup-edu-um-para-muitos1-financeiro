package br.com.zup.edu.umparamuitos1financeiro.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class NotaFiscal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String numero;
	private BigDecimal total;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	
	public NotaFiscal(String numero, BigDecimal total, List<Item> itens) {
		this.numero = numero;
		this.total = total;
		this.itens = itens;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public NotaFiscal() {
		
	}
    
	public Long getId() {
		return id;
	}

	public List<Item> getItens() {
		return itens;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
}
