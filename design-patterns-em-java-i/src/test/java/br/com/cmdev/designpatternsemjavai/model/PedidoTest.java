package br.com.cmdev.designpatternsemjavai.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.service.impl.GeraPedido;
import br.com.cmdev.designpatternsemjavai.service.impl.GeraPedidoHandler;

class PedidoTest {

	@Test
	/**
	 * Aplicando o pattern Command e Command Handler
	 */
	void deveriaGerarUmNovoPedido() {
		
		GeraPedido gerador = new GeraPedido("Ana Paula", new BigDecimal("600.00"), 4);
		GeraPedidoHandler handler = new GeraPedidoHandler(/* repository */);
		handler.executa(gerador);
	}

}
