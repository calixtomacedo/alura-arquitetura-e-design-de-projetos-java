package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;

public class DescontoOrsamentoMaisCincoItens extends Desconto {

	public DescontoOrsamentoMaisCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarCalculo(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.1"));
	}

	@Override
	public boolean deveAplicar(Orsamento orsamento) {
		return orsamento.getQuantidateItens() > 5;
	}

}
