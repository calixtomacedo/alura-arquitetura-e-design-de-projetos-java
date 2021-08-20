package br.com.cmdev.designpatternsemjavai.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;

class CalculadoraDeDescontosTest {

	@Test
	void deveriaRetornarUmValorMaiorQueZeroBaseadoNasRegrasDeDesconto() {
		Orsamento orsamento = new Orsamento(new  BigDecimal("500.02"), 5);
		CalculadoraDeDescontos desconto = new CalculadoraDeDescontos();
		BigDecimal valorDesconto = desconto.calcular(orsamento);
		
		assertTrue(valorDesconto.doubleValue() > 0);
	}
	
	@Test
	void deveriaRetornarZeroPorqueNaoEntraNasRegrasDeDesconto() {
		Orsamento orsamento = new Orsamento(new  BigDecimal("500.00"), 5);
		CalculadoraDeDescontos desconto = new CalculadoraDeDescontos();
		BigDecimal valorDesconto = desconto.calcular(orsamento);
		
		assertTrue(valorDesconto.equals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN)));
	}

}
