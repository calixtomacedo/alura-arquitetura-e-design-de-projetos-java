package br.com.cmdev.tddejava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void deveriaRetornarASomaDoAmaisB() {
		int a = 5, b = 10;
		int soma = new Calculadora().somar(a, b);
		assertEquals(soma, 15);
	}

}
