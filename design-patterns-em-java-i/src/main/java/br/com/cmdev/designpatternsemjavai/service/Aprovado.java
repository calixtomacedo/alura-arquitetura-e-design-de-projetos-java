package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrsamento;

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
