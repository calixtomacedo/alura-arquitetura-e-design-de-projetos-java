package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsii.model.Orsamento;

public class DescontoOrsamentoValorMaiorQuinhentos extends Desconto {

	public DescontoOrsamentoValorMaiorQuinhentos(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarCalculo(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.05").setScale(2, RoundingMode.HALF_EVEN));
	}

	@Override
	public boolean deveAplicar(Orsamento orsamento) {
		return orsamento.getValor().compareTo(new BigDecimal("500.00")) > 0;
	}

}
