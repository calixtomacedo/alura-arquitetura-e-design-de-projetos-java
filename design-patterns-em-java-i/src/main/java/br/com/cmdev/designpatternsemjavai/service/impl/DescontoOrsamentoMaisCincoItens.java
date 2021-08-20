package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;

public class DescontoOrsamentoMaisCincoItens extends Desconto {

	public DescontoOrsamentoMaisCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarCalculo(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.1").setScale(2, RoundingMode.HALF_EVEN));
	}

	@Override
	public boolean deveAplicar(Orsamento orsamento) {
		return orsamento.getQuantidateItens() > 5;
	}

}
