package br.com.cmdev.designpatternsii.service;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.model.Orsamento;

public interface Imposto {
	BigDecimal calcular(Orsamento orsamento);
}
