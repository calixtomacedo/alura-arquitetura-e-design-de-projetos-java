package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

/**
 * Aplicando o pattern Command
 */
public class GeraPedido {
	
	private String cliente;
	private BigDecimal valorOrsamento;
	private int quantidadeItens;

	public GeraPedido(String cliente, BigDecimal valorOrsamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrsamento = valorOrsamento;
		this.quantidadeItens = quantidadeItens;
	}
	
	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrsamento() {
		return valorOrsamento;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
}
