package br.com.cmdev.tddejava.service;

import java.math.BigDecimal;

import br.com.cmdev.tddejava.model.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			valor = BigDecimal.ZERO;
		}
		return valor;
	}
}
