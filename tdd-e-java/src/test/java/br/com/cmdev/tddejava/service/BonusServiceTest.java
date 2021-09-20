package br.com.cmdev.tddejava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.cmdev.tddejava.model.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaRetornarValorEquivalentoADezPorCentoDoSalario() {
		Funcionario funcionario = new Funcionario("Caio Macedo", LocalDate.of(2019, 06, 24), new BigDecimal("8000.00"));
		BigDecimal bonus = new BonusService().calcularBonus(funcionario);
		
		assertEquals(funcionario.getNome(), "Caio Macedo");
		assertEquals(funcionario.getDataAdmissao(), LocalDate.of(2019, 06, 24));
		assertEquals(new BigDecimal("800.00"), bonus);
	}

	@Test
	void deveriaRetornarZeroQuandoDezPorCentoParaSalarioForSuperiorAMil() {
		Funcionario funcionario = new Funcionario("Caio Macedo", LocalDate.of(2019, 06, 24), new BigDecimal("12000.00"));
		BigDecimal bonus = new BonusService().calcularBonus(funcionario);
		assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), bonus);
	}
	
	@Test
	void deveriaRetornarValorEquivalentoADezPorCentoParaSalarioExatamenteMil() {
		Funcionario funcionario = new Funcionario("Caio Macedo", LocalDate.of(2019, 06, 24), new BigDecimal("10000.00"));
		BigDecimal bonus = new BonusService().calcularBonus(funcionario);
		assertEquals(new BigDecimal("1000.00").setScale(2, RoundingMode.HALF_UP), bonus);
	}
}
