package br.com.cmdev.solidcomjava.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cmdev.solidcomjava.service.Reajuste;

public class Anuenio implements Reajuste {

	private BigDecimal valor;
	private LocalDate data;
	
	public Anuenio(BigDecimal valor) {
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

}
