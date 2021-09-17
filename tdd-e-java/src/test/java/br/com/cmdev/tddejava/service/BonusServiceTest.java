package br.com.cmdev.tddejava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.cmdev.tddejava.model.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaRetornarUmValorDeBonus() {
		Funcionario funcionario = new Funcionario("Caio Macedo", LocalDate.of(2019, 06, 24), new BigDecimal("8000"));
		BigDecimal bonus = new BonusService().calcularBonus(funcionario);
		
		assertEquals(funcionario.getNome(), "Caio Macedo");
		assertEquals(funcionario.getDataAdmissao(), LocalDate.of(2019, 06, 24));
		assertEquals(new BigDecimal("800").setScale(1), bonus);
	}


	@Test
	void deveriaRetornarValorZero() {
		Funcionario funcionario = new Funcionario("Caio Macedo", LocalDate.of(2019, 06, 24), new BigDecimal("12000"));
		BigDecimal bonus = new BonusService().calcularBonus(funcionario);
		assertEquals(new BigDecimal("0"), bonus);
	}
}
