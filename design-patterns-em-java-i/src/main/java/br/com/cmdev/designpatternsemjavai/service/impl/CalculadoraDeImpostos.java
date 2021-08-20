package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.enuns.TipoImposto;
import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Imposto;

public class CalculadoraDeImpostos {

	/**
	 *  Sem implementação do Pattern Stratagy
	 */
	public BigDecimal calcular(Orsamento orsamento, TipoImposto tipoImposto) {
		switch (tipoImposto) {
		case ICMS:
			return orsamento.getValor().multiply(new BigDecimal("0.1"));
		case ISS:
			return orsamento.getValor().multiply(new BigDecimal("0.06"));
		default:
			return BigDecimal.ZERO;
		}
	}
	
	/**
	 *  Com implementação do Pattern Stratagy
	 */
	public BigDecimal calcular(Orsamento orsamento, Imposto imposto) {
		return imposto.calcular(orsamento);
	}
}
