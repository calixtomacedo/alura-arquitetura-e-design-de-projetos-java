package br.com.cmdev.designpatternsii.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.service.impl.StatusOrcamento;

/**
 * Aplicando o pattern State
 */
public class Aprovado extends StatusOrcamento {

	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.02"));
	}
	
	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setStatus(new Finalizado());
	}
	
}
