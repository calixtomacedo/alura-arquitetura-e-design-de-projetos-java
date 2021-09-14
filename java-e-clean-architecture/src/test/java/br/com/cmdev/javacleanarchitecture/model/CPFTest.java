package br.com.cmdev.javacleanarchitecture.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void deveriaCriarCPFCasoDadoSejaValido() {
		CPF cpf = new CPF("000.000.000-00");
		assertEquals(14, cpf.getNumero().length());
	}
	
	@Test
	void naoDeveriaCriarCPFCasoDadoSejaInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("11122000"));
	}

}
