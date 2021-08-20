package br.com.cmdev.designpatternsemjavai.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.service.EmAnalise;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrsamento;

public class Orsamento {

	private BigDecimal valor;
	private int quantidateItens;
	private StatusOrsamento status;

	public Orsamento(BigDecimal valor, int quantidateItens) {
		this.valor = valor;
		this.quantidateItens = quantidateItens;
		this.status = new EmAnalise();
	}
	
	/**
	 * Aplicando o pattern State
	 */
	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.status.calcularValorDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
	}
	
	/**
	 * Aplicando o pattern State
	 */
	public void aprovar() {
		this.status.aprovar(this);
	}
	
	/**
	 * Aplicando o pattern State
	 */
	public void reprovar() {
		this.status.reprovar(this);
	}
	
	/**
	 * Aplicando o pattern State
	 */
	public void finalizar() {
		this.status.finalizar(this);
	}

	public BigDecimal getValor() {
		return valor.setScale(2, RoundingMode.HALF_EVEN);
	}

	public int getQuantidateItens() {
		return quantidateItens;
	}

	public StatusOrsamento getStatus() {
		return status;
	}

	public void setStatus(StatusOrsamento status) {
		this.status = status;
	}

}
