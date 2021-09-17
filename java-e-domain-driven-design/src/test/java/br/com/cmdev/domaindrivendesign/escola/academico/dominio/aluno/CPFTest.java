package br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.CPF;

class CPFTest {


	@Test
	void deveriaCriarCPFCasoDadoSejaValido() {
		CPF cpf = new CPF("123.456.789-00");
		assertEquals(14, cpf.getNumero().length());
	}
	
	@Test
	void naoDeveriaCriarCPFCasoDadoSejaInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("11122000"));
	}

}
