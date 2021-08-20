package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Desconto;

public class DescontoOrsamentoValorMaiorQuinhentos extends Desconto {

	public DescontoOrsamentoValorMaiorQuinhentos(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orsamento orsamento) {
		if (orsamento.getValor().compareTo(new BigDecimal("500.00")) > 0) {
			return orsamento.getValor().multiply(new BigDecimal("0.05").setScale(2, RoundingMode.HALF_EVEN));
		}
		return proximo.calcular(orsamento);
	}

}
