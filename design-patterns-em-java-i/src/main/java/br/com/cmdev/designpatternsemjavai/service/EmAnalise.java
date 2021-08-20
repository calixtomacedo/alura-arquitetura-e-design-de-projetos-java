package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrsamento;

/**
 * Aplicando o pattern State
 */
public class EmAnalise extends StatusOrsamento {

	public BigDecimal calcularValorDescontoExtra(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.05"));
	}
	
	public void aprovar(Orsamento orsamento) {
		orsamento.setStatus(new Aprovado());
	}
	
	public void reprovar(Orsamento orsamento) {
		orsamento.setStatus(new Reprovado());
	}
}
