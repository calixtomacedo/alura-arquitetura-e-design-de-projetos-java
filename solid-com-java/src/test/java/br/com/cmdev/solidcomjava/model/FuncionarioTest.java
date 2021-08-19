package br.com.cmdev.solidcomjava.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.solidcomjava.ValidacaoException;
import br.com.cmdev.solidcomjava.service.ReajusteService;

class FuncionarioTest {

	@Test
	void deveriaAumentarOSalarioDeUmFuncionarioComAcressimoDe100Reais() {
		Funcionario funcionario = new Funcionario("Calixto Macedo", "123654789741", Cargo.ESPECIALISTA, new BigDecimal("250.00"));
		new ReajusteService().reajustarSalarioDoFuncionario(funcionario, new BigDecimal("100.00"));
		assertEquals( new BigDecimal("350.00"), funcionario.getSalario());
	}
	
	@Test
	void deveriaNaoPassarPeloValidacaoException() {
		Funcionario funcionario = new Funcionario("Calixto Macedo", "123654789741", Cargo.ESPECIALISTA, new BigDecimal("150.00"));
		assertThrows(ValidacaoException.class, () -> {
			new ReajusteService().reajustarSalarioDoFuncionario(funcionario, new BigDecimal("100.00"));
		});
	}

}
