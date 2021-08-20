package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Desconto;

public class DescontoOrsamentoMaisCincoItens extends Desconto {

	public DescontoOrsamentoMaisCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orsamento orsamento) {
		if (orsamento.getQuantidateItens() > 5) {
			return orsamento.getValor().multiply(new BigDecimal("0.1").setScale(2, RoundingMode.HALF_EVEN));
		}
		return proximo.calcular(orsamento);
	}

}
