package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.DomainException;
import br.com.cmdev.designpatternsii.model.Orcamento;

/**
 * Aplicando o pattern State
 */
public abstract class StatusOrcamento {

	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Este Orçamento não pode ser aprovado!");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Este Orçamento não pode ser reprovado!");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Este Orçamento não pode ser finalizado!");
	}
}
