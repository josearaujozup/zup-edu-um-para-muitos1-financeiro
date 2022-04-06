package br.com.zup.edu.umparamuitos1financeiro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nome;
	private String empresa;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "contato")
	private List<Telefone> telefones = new ArrayList<>();

	public Contato(String nome, String empresa) {
		this.nome = nome;
		this.empresa = empresa;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Contato() {
    	
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void adiciona(Telefone telefone) {
		telefone.setContato(this);
		this.telefones.add(telefone);
	}
}
