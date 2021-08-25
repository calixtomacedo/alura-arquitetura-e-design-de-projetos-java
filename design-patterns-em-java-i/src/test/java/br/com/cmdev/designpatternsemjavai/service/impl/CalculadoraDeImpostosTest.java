package br.com.cmdev.designpatternsemjavai.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

class CalculadoraDeImpostosTest {

	@Test
	void deveriaCalcularDezPorCentoDoValorPassadoNoOrcamentoParaISMS() {
		Orcamento orcamento = new Orcamento(new BigDecimal("100.00"), 1);
		CalculadoraDeImpostos imposto = new CalculadoraDeImpostos();
		BigDecimal valorImposto = imposto.calcular(orcamento, new ICMS());
		
		assertEquals(new BigDecimal("10.00"), valorImposto.setScale(2, RoundingMode.HALF_EVEN));
	}
	
	@Test
	void deveriaCalcularSeisPorCentoDoValorPassadoNoOrcamentoParaISS() {
		Orcamento orcamento = new Orcamento(new BigDecimal("100.00"), 1);
		CalculadoraDeImpostos imposto = new CalculadoraDeImpostos();
		BigDecimal valorImposto = imposto.calcular(orcamento, new ISS());
		
		assertEquals(new BigDecimal("6.00"), valorImposto.setScale(2, RoundingMode.HALF_EVEN));
	}

}
