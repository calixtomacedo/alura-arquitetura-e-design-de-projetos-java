package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal efetuarCalculo(Orsamento orsamento) {
		return BigDecimal.ZERO;
	}

	@Override
	public boolean deveAplicar(Orsamento orsamento) {
		return true;
	}

}
