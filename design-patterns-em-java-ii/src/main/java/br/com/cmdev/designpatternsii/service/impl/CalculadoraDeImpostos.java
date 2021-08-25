package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.enuns.TipoImposto;
import br.com.cmdev.designpatternsii.model.Orsamento;
import br.com.cmdev.designpatternsii.service.Imposto;

public class CalculadoraDeImpostos {

	/**
	 * Sem aplicação do pattern Stratagy
	 * @param orsamento
	 * @param imposto
	 * @return BigDecimal
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
	 * Aplicando o pattern Stratagy
	 * @param orsamento
	 * @param imposto
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orsamento orsamento, Imposto imposto) {
		return imposto.calcular(orsamento);
	}
}
