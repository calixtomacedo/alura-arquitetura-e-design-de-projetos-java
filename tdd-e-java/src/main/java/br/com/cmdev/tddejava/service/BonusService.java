package br.com.cmdev.tddejava.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.tddejava.model.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valorBonus = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valorBonus.compareTo(new BigDecimal("1000")) > 0) {
			//valorBonus = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
			throw new IllegalArgumentException("Funcionario com salario maior do que R$10.000 não pode receber bonus!");
		}
		return valorBonus.setScale(2, RoundingMode.HALF_UP);
	}
}
