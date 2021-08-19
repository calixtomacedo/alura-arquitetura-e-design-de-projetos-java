package br.com.cmdev.solidcomjava.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cmdev.solidcomjava.service.ReajusteTributavel;

public class Promocao implements ReajusteTributavel {

	private BigDecimal valor;
	private LocalDate data;
	
	public Promocao(BigDecimal valor) {
		this.valor = valor;
		this.data = LocalDate.now();
	}

	@Override
	public BigDecimal valor() {
		return valor;
	}

	@Override
	public LocalDate data() {
		return data;
	}

	@Override
	public BigDecimal valorImpostoDeRenda() {
		return valor.multiply(new BigDecimal("0.1"));
	}

}
