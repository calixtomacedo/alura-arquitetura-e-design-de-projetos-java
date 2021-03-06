package br.com.cmdev.designpatternsii.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import br.com.cmdev.designpatternsii.action.AcoesAposGerarPedido;
import br.com.cmdev.designpatternsii.model.ItemOrcamento;
import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.model.Pedido;

/**
 * Aplicando o pattern Command Handler
 */
public class GeraPedidoHandler {
	
	private List<AcoesAposGerarPedido> acoes;
	
	/**
	 * Aplicando o pattern Observer
	 */
	public GeraPedidoHandler(List<AcoesAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(dados.getValorOrcamento()));
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		/**
		 * Aplicando o pattern Observer
		 */
		acoes.forEach(acao -> acao.executar(pedido));
	}
}
