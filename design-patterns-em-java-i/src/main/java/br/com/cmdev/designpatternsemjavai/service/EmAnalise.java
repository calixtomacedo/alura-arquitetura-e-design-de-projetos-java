package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrcamento;

/**
 * Aplicando o pattern State
 */
public class EmAnalise extends StatusOrcamento {

	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}
	
	public void aprovar(Orcamento orcamento) {
		orcamento.setStatus(new Aprovado());
	}
	
	public void reprovar(Orcamento orcamento) {
		orcamento.setStatus(new Reprovado());
	}
}
