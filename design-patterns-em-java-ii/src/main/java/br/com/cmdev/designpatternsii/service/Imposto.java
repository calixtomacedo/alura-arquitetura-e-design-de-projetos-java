package br.com.cmdev.designpatternsii.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orcamento;

public abstract class Imposto {
	
	private Imposto outroImposto;

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto = realizarCalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;
		
		if(outroImposto != null) {
			valorOutroImposto = outroImposto.realizarCalculo(orcamento);
		}
		
		return valorImposto.add(valorOutroImposto);
	}

}
