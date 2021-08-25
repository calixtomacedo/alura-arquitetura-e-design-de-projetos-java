package br.com.cmdev.designpatternsii.http;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.service.RegistroDeOrcamento;

class JavaHttpClientTest {

	@Test
	void testConnectionWithAPI() {
		Orcamento orcamento = new Orcamento(new BigDecimal("500.00"), 10);
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
		registro.registrar(orcamento);
	}

}
