package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

public interface Imposto {
	BigDecimal calcular(Orcamento orcamento);
}
