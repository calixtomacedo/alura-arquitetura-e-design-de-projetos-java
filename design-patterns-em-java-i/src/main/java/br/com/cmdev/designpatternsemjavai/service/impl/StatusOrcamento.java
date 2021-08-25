package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.DomainException;
import br.com.cmdev.designpatternsemjavai.model.Orcamento;

/**
 * Aplicando o pattern State
 */
public abstract class StatusOrcamento {

	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Este orçamento não pode ser aprovado!");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Este orçamento não pode ser reprovado!");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Este orçamento não pode ser finalizado!");
	}
}
