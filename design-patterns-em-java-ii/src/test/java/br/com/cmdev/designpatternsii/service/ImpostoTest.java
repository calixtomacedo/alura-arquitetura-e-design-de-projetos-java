package br.com.cmdev.designpatternsii.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.service.impl.CalculadoraDeImpostos;
import br.com.cmdev.designpatternsii.service.impl.ICMS;
import br.com.cmdev.designpatternsii.service.impl.ISS;

class ImpostoTest {

	@Test
	void testCalcularImpostos() {
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		BigDecimal iss = calculadora.calcular(orcamento, new ISS(null));
		BigDecimal issAndIcms = calculadora.calcular(orcamento, new ISS(new ICMS(null)));
		
		assertEquals(new BigDecimal("6.00"), iss);
		assertEquals(new BigDecimal("16.00"), issAndIcms);
	}

}
