package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;

/**
 * Aplicando o pattern Command
 */
public class GeraPedido {
	
	private String cliente;
	private BigDecimal valorOrcamento;
	private int quantidadeItens;

	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeItens = quantidadeItens;
	}
	
	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
}
