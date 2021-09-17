package br.com.cmdev.tddejava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void deveriaSomarDoisNumerosPositivos() {
		int soma = new Calculadora().somar(3, 7);
		assertEquals(10, soma);
	}

}
