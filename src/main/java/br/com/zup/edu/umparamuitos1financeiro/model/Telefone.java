package br.com.zup.edu.umparamuitos1financeiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String tipo;
	private String numero;
	
	@ManyToOne
	private Contato contato;

	public Telefone(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public Telefone() {
		
	}
    
	public Long getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNumero() {
		return numero;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
