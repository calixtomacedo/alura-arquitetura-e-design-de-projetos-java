package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;
import br.com.cmdev.designpatternsemjavai.service.Imposto;

public class ICMS implements Imposto {

	public BigDecimal calcular(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}
}
