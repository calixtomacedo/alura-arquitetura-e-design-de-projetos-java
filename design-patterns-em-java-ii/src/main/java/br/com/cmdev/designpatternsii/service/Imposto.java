package br.com.cmdev.designpatternsii.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;

public abstract class Imposto {
	
	private Imposto outroImposto;

	protected abstract BigDecimal realizarCalculo(Orsamento orsamento);

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public BigDecimal calcular(Orsamento orsamento) {
		BigDecimal valorImposto = realizarCalculo(orsamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;
		
		if(outroImposto != null) {
			valorOutroImposto = outroImposto.realizarCalculo(orsamento);
		}
		
		return valorImposto.add(valorOutroImposto);
	}

}
