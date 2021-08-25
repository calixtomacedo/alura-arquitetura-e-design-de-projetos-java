package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

public abstract class Desconto {

	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	/**
	 * Aplicando o pattern Template Method para reaproveitar trechos de códigos comuns, evitando duplicações
	 * @param orcamento
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orcamento orcamento) {
		if (deveAplicar(orcamento)) {
			return efetuarCalculo(orcamento);
		}
		return proximo.calcular(orcamento);
	}
	
	protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
	protected abstract boolean deveAplicar(Orcamento orcamento);
}
