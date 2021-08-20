package br.com.cmdev.designpatternsemjavai.action;

import br.com.cmdev.designpatternsemjavai.model.Pedido;

/**
 * Aplicando o pattern Observer
 */
public interface AcoesAposGerarPedido {
	
	public void executar(Pedido pedido);
	
}
