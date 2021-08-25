package br.com.cmdev.designpatternsii.action;

import br.com.cmdev.designpatternsii.model.Pedido;

/**
 * Aplicando o pattern Facade 
 */
public class LogDePedido implements AcoesAposGerarPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Pedido gerado com sucesso: "+pedido.getCliente());
	}

}
