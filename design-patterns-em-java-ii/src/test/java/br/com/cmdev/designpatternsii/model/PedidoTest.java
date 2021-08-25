package br.com.cmdev.designpatternsii.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsii.action.AcoesAposGerarPedido;
import br.com.cmdev.designpatternsii.action.EnviarEmailPedido;
import br.com.cmdev.designpatternsii.action.LogDePedido;
import br.com.cmdev.designpatternsii.action.SalvarPedidoNoBancoDeDados;
import br.com.cmdev.designpatternsii.service.impl.GeraPedido;
import br.com.cmdev.designpatternsii.service.impl.GeraPedidoHandler;

class PedidoTest {

	@Test
	/**
	 * Aplicando o pattern Command e Command Handler
	 * Aplicando o pattern Facade
	 */
	void deveriaGerarUmNovoPedido() {
		GeraPedido pedido = new GeraPedido("Ana Paula", new BigDecimal("600.00"), 4);
		/**
		 * Aplicando o pattern Observer
		 */
		List<AcoesAposGerarPedido> acoes = Arrays.asList(
				new SalvarPedidoNoBancoDeDados(), 
				new EnviarEmailPedido(),
				new LogDePedido());
		GeraPedidoHandler handler = new GeraPedidoHandler(acoes);
		handler.executa(pedido);
	}

}
