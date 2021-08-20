package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.DomainException;
import br.com.cmdev.designpatternsemjavai.model.Orsamento;

/**
 * Aplicando o pattern State
 */
public abstract class StatusOrsamento {

	public BigDecimal calcularValorDescontoExtra(Orsamento orsamento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orsamento orsamento) {
		throw new DomainException("Este orsamento não pode ser aprovado!");
	}
	
	public void reprovar(Orsamento orsamento) {
		throw new DomainException("Este orsamento não pode ser reprovado!");
	}
	
	public void finalizar(Orsamento orsamento) {
		throw new DomainException("Este orsamento não pode ser finalizado!");
	}
}
