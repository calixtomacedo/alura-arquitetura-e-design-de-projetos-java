package br.com.cmdev.designpatternsemjavai.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.impl.CalculadoraDeImpostos;
import br.com.cmdev.designpatternsemjavai.service.impl.ICMS;
import br.com.cmdev.designpatternsemjavai.service.impl.ISS;

class CalculadoraDeImpostosTest {

	@Test
	void deveriaCalcularDezPorCentoDoValorPassadoNoOrsamentoParaISMS() {
		Orsamento orsamento = new Orsamento(new BigDecimal("100.00"));
		CalculadoraDeImpostos imposto = new CalculadoraDeImpostos();
		BigDecimal valorImposto = imposto.calcular(orsamento, new ICMS());
		
		assertEquals(new BigDecimal("10.00"), valorImposto.setScale(2, RoundingMode.HALF_EVEN));
	}
	
	@Test
	void deveriaCalcularSeisPorCentoDoValorPassadoNoOrsamentoParaISS() {
		Orsamento orsamento = new Orsamento(new BigDecimal("100.00"));
		CalculadoraDeImpostos imposto = new CalculadoraDeImpostos();
		BigDecimal valorImposto = imposto.calcular(orsamento, new ISS());
		
		assertEquals(new BigDecimal("6.00"), valorImposto.setScale(2, RoundingMode.HALF_EVEN));
	}

}
