package br.com.cmdev.designpatternsemjavai.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Orsamento {

	private BigDecimal valor;
	private int quantidateItens;

	public Orsamento(BigDecimal valor, int quantidateItens) {
		this.valor = valor;
		this.quantidateItens = quantidateItens;
	}

	public BigDecimal getValor() {
		return valor.setScale(2, RoundingMode.HALF_EVEN);
	}

	public int getQuantidateItens() {
		return quantidateItens;
	}

}
