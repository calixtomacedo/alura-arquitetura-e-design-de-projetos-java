package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

public class CalculadoraDeDescontos {

	/**
	 * Sem aplicação do pattern Chain of Responsibility 
	 * @param orcamento
	 * @return BigDecimal
	 */
	public BigDecimal calcularSemPattern(Orcamento orcamento) {
		if(orcamento.getQuantidateItens() > 5) {
			return  orcamento.getValor().multiply(new BigDecimal("0.1"));
		}
		if(orcamento.getValor().compareTo(new BigDecimal("500.00")) > 0) {
			return  orcamento.getValor().multiply(new BigDecimal("0.1").setScale(2, RoundingMode.HALF_EVEN));
		}
		return BigDecimal.ZERO;
	}
	
	/**
	 * Aplicando o pattern Chain of Responsibility 
	 * @param orcamento
	 * @return BigDecimal
	 */
	public BigDecimal calcular(Orcamento orcamento) {
		Desconto descontos = new DescontoOrcamentoMaisCincoItens(
				new DescontoOrcamentoValorMaiorQuinhentos(
						new SemDesconto()));
		return descontos.calcular(orcamento);
	}
}
