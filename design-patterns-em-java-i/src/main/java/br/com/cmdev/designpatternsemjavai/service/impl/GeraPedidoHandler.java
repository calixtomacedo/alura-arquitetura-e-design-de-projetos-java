package br.com.cmdev.designpatternsemjavai.service.impl;

import java.time.LocalDateTime;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.model.Pedido;

/**
 * Aplicando o pattern Command Handler
 */
public class GeraPedidoHandler {

	// Injeção de dependencia como: repository, dao, services etc.
	public GeraPedidoHandler(/* PedidoRepository repository */) {
		// this.repository = repository;
	}
	
	public void executa(GeraPedido dados) {
		Orsamento orsamento = new Orsamento(dados.getValorOrsamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orsamento);
		
		// repository.save(pedido);
		System.out.println("Salvar pedido no banco de dados");
		System.out.println("Enviar email com dados do novo pedido: "+pedido);
	}
}
