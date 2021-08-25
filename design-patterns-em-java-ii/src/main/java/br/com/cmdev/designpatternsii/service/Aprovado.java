package br.com.cmdev.designpatternsii.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;
import br.com.cmdev.designpatternsii.service.impl.StatusOrsamento;

/**
 * Aplicando o pattern State
 */
public class Aprovado extends StatusOrsamento {

	public BigDecimal calcularValorDescontoExtra(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.02"));
	}
	
	@Override
	public void finalizar(Orsamento orsamento) {
		orsamento.setStatus(new Finalizado());
	}
	
}
