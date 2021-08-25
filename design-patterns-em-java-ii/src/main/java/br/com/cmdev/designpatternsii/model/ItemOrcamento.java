package br.com.cmdev.designpatternsii.model;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.service.Orcavel;

/**
 * Aplicando o pattern Composite
 */
public class ItemOrcamento implements Orcavel {

	private BigDecimal valor;

	public ItemOrcamento(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}


}
