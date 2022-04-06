package br.com.zup.edu.umparamuitos1financeiro.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.umparamuitos1financeiro.model.Item;
import br.com.zup.edu.umparamuitos1financeiro.model.NotaFiscal;

public class NotaFiscalDTO {
	
	@NotBlank
	private String numero;
	
	@NotNull
	@Positive
	private BigDecimal total;
	
	@Valid
	@NotEmpty
	private List<ItemDTO> itens;

	public NotaFiscalDTO(String numero, BigDecimal total, List<ItemDTO> itens) {
		this.numero = numero;
		this.total = total;
		this.itens = itens;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<ItemDTO> getItens() {
		return itens;
	}

	public NotaFiscal toModel() {
		List<Item> itensDeNota = itens.stream()
				.map(i -> i.toModel())
				.collect(Collectors.toList());
		
		return new NotaFiscal(numero, total, itensDeNota);
	}
	
}
