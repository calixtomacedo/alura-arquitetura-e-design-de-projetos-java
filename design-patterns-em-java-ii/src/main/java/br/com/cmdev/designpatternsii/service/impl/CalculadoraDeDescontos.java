package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsii.model.Orsamento;

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
			return  orsamento.getValor().multiply(new BigDecimal("0.1"));
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * Aplicando o pattern Chain of Responsibility 
	 * @param orsamento
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orsamento orsamento) {
		Desconto descontos = new DescontoOrsamentoMaisCincoItens(
				new DescontoOrsamentoValorMaiorQuinhentos(
						new SemDesconto()));
		return descontos.calcular(orsamento);
	}
}
