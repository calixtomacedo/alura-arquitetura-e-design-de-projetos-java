package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Desconto;

public class SemDesconto extends Desconto {

	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal calcular(Orsamento orsamento) {
		return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
	}

}
