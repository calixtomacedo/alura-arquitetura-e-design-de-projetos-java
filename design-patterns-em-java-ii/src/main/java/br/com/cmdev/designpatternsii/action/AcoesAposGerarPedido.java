package br.com.cmdev.designpatternsii.action;

import br.com.cmdev.designpatternsii.model.Pedido;

/**
 * Aplicando o pattern Observer
 */
public interface AcoesAposGerarPedido {
	
	public void executar(Pedido pedido);
	
}
