package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;

public abstract class Desconto {

	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	/**
	 * Aplicando o pattern Template Method para reaproveitar trechos de códigos comuns, evitando duplicações
	 * @param orsamento
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orsamento orsamento) {
		if (deveAplicar(orsamento)) {
			return efetuarCalculo(orsamento);
		}
		return proximo.calcular(orsamento);
	}
	
	protected abstract BigDecimal efetuarCalculo(Orsamento orsamento);
	protected abstract boolean deveAplicar(Orsamento orsamento);
}
