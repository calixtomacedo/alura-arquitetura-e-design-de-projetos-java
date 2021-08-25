package br.com.cmdev.designpatternsii.model;

import java.math.BigDecimal;

import br.com.cmdev.designpatternsii.service.EmAnalise;
import br.com.cmdev.designpatternsii.service.Finalizado;
import br.com.cmdev.designpatternsii.service.impl.StatusOrcamento;

public class Orcamento {

	private BigDecimal valor;
	private int quantidateItens;
	private StatusOrcamento status;

	public Orcamento(BigDecimal valor, int quantidateItens) {
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
		return valor;
	}

	public int getQuantidateItens() {
		return quantidateItens;
	}

	public StatusOrcamento getStatus() {
		return status;
	}

	public void setStatus(StatusOrcamento status) {
		this.status = status;
	}

	/**
	 * Aplicando o pattern Adapter
	 */
	public boolean isFinalizado() {
		return status instanceof Finalizado;
	}

}
