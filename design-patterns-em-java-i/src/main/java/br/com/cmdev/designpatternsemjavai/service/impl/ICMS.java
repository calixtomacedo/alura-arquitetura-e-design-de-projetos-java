package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.Imposto;

public class ICMS implements Imposto {

	public BigDecimal calcular(Orsamento orsamento) {
		return orsamento.getValor().multiply(new BigDecimal("0.1"));
	}
}
