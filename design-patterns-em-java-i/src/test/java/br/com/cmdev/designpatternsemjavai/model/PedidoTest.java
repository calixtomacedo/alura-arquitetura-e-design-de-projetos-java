package br.com.cmdev.designpatternsemjavai.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsemjavai.action.AcoesAposGerarPedido;
import br.com.cmdev.designpatternsemjavai.action.EnviarEmailPedido;
import br.com.cmdev.designpatternsemjavai.action.SalvarPedidoNoBancoDeDados;
import br.com.cmdev.designpatternsemjavai.service.impl.GeraPedido;
import br.com.cmdev.designpatternsemjavai.service.impl.GeraPedidoHandler;

class PedidoTest {

	@Test
	/**
	 * Aplicando o pattern Command e Command Handler
	 */
	void deveriaGerarUmNovoPedido() {
		GeraPedido pedido = new GeraPedido("Ana Paula", new BigDecimal("600.00"), 4);
		/**
		 * Aplicando o pattern Observer
		 */
		List<AcoesAposGerarPedido> acoes = Arrays.asList(new SalvarPedidoNoBancoDeDados(), new EnviarEmailPedido());
		GeraPedidoHandler handler = new GeraPedidoHandler(acoes);
		handler.executa(pedido);
	}

}
