package br.com.cmdev.designpatternsemjavai.model;

import java.math.BigDecimal;

public class Orsamento {
	
	private BigDecimal valor;

	public Orsamento(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
