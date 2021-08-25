package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.enuns.TipoImposto;
import br.com.cmdev.designpatternsemjavai.model.Orcamento;
import br.com.cmdev.designpatternsemjavai.service.Imposto;

public class CalculadoraDeImpostos {

	/**
	 * Sem aplicação do pattern Stratagy
	 * @param orcamento
	 * @param imposto
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {
		switch (tipoImposto) {
		case ICMS:
			return orcamento.getValor().multiply(new BigDecimal("0.1"));
		case ISS:
			return orcamento.getValor().multiply(new BigDecimal("0.06"));
		default:
			return BigDecimal.ZERO;
		}
	}
	
	/**
	 * Aplicando o pattern Stratagy
	 * @param orcamento
	 * @param imposto
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
	}
}
