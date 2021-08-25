package br.com.cmdev.designpatternsemjavai.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

class CalculadoraDeDescontosTest {

	@Test
	void deveriaRetornarUmValorMaiorQueZeroBaseadoNasRegrasDeDesconto() {
		Orcamento orcamento = new Orcamento(new  BigDecimal("500.02"), 5);
		CalculadoraDeDescontos desconto = new CalculadoraDeDescontos();
		BigDecimal valorDesconto = desconto.calcular(orcamento);
		
		assertTrue(valorDesconto.doubleValue() > 0);
	}
	
	@Test
	void deveriaRetornarZeroPorqueNaoEntraNasRegrasDeDesconto() {
		Orcamento orcamento = new Orcamento(new  BigDecimal("500.00"), 5);
		CalculadoraDeDescontos desconto = new CalculadoraDeDescontos();
		BigDecimal valorDesconto = desconto.calcular(orcamento);
		
		System.out.println(valorDesconto);
		
		assertTrue(valorDesconto.equals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN)));
	}

}
