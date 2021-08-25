package br.com.cmdev.designpatternsii.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;
import br.com.cmdev.designpatternsii.service.Imposto;

public class ICMS extends Imposto {

	public ICMS(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public BigDecimal realizarCalculo(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.1"));
	}
}
