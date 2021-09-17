package br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecoInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("invalido"));
	}
	
	@Test
	void deveriaCriarEmailsComEnderecoValidos() {
		Email email = new Email("calixto.macedo@gmail.com");
		assertEquals(email.getEndereco(), "calixto.macedo@gmail.com");
	}

}
