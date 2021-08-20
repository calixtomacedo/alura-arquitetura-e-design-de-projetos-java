package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;

public abstract class Desconto {

	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	public abstract BigDecimal calcular(Orsamento orsamento);
}
