package br.com.cmdev.designpatternsii.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.cmdev.designpatternsii.service.EmAnalise;
import br.com.cmdev.designpatternsii.service.Finalizado;
import br.com.cmdev.designpatternsii.service.Orcavel;
import br.com.cmdev.designpatternsii.service.impl.StatusOrcamento;

public class Orcamento implements Orcavel {

	private BigDecimal valor;
	private StatusOrcamento status;
	
	/**
	 * Aplicando o pattern Composite
	 */
	private List<Orcavel> Itens;

	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.status = new EmAnalise();
		this.Itens = new ArrayList<Orcavel>();
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
		return Itens.size();
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

	/**
	 * Aplicando o pattern Composite
	 */
	public void adicionarItem(Orcavel item) {
		this.valor = valor.add(item.getValor());
		this.Itens.add(item);
	}
}
