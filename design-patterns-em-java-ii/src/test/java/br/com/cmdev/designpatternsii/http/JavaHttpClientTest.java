package br.com.cmdev.designpatternsii.http;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsii.model.Orsamento;
import br.com.cmdev.designpatternsii.service.RegistroDeOrsamento;

class JavaHttpClientTest {

	@Test
	void testConnectionWithAPI() {
		Orsamento orsamento = new Orsamento(new BigDecimal("500.00"), 10);
		orsamento.aprovar();
		orsamento.finalizar();
		
		RegistroDeOrsamento registro = new RegistroDeOrsamento(new JavaHttpClient());
		registro.registrar(orsamento);
	}

}
