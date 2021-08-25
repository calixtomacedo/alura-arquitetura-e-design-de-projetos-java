package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrcamento;

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
