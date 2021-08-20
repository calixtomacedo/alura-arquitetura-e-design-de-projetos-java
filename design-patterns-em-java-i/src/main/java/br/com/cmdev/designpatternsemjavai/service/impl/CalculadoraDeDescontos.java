package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Desconto;

public class CalculadoraDeDescontos {

	/**
	 * Sem aplicação do pattern Chain of Responsibility 
	 * @param orsamento
	 * @return BigDecimal
	 */
	public BigDecimal calcularSemPattern(Orsamento orsamento) {
		if(orsamento.getQuantidateItens() > 5) {
			return  orsamento.getValor().multiply(new BigDecimal("0.1"));
		}
		if(orsamento.getValor().compareTo(new BigDecimal("500.00")) > 0) {
			return  orsamento.getValor().multiply(new BigDecimal("0.1").setScale(2, RoundingMode.HALF_EVEN));
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * Aplicando o pattern Chain of Responsibility 
	 * @param orsamento
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orsamento orsamento) {
		Desconto desconto = new DescontoOrsamentoMaisCincoItens(
				new DescontoOrsamentoValorMaiorQuinhentos(
						new SemDesconto()));
		return desconto.calcular(orsamento);
	}
}
