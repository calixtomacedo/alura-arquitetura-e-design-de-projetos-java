package br.com.cmdev.designpatternsemjavai.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;

public interface Imposto {
	BigDecimal calcular(Orsamento orsamento);
}
