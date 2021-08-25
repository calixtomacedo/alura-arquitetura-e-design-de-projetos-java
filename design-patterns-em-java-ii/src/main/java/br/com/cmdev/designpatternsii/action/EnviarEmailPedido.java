package br.com.cmdev.designpatternsii.action;

import br.com.cmdev.designpatternsii.model.Pedido;

/**
 * Aplicando o pattern Observer
 */
public class EnviarEmailPedido implements AcoesAposGerarPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Aqui ficaria o fonte do processo de enviar email");
	}
}
