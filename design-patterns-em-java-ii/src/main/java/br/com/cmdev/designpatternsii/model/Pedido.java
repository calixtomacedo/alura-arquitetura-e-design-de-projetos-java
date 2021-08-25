package br.com.cmdev.designpatternsii.model;

import java.time.LocalDateTime;

public class Pedido {

	private String cliente;
	private LocalDateTime data;
	private Orsamento orsamento;

	public Pedido(String cliente, LocalDateTime data, Orsamento orsamento) {
		this.cliente = cliente;
		this.data = data;
		this.orsamento = orsamento;
	}

	public String getCliente() {
		return cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Orsamento getOrsamento() {
		return orsamento;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + cliente + ", data=" + data + ", orsamento=" + orsamento + "]";
	}

}
