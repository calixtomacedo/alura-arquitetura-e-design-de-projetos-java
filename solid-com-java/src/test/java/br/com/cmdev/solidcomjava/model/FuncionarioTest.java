package br.com.cmdev.solidcomjava.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.solidcomjava.ValidacaoException;
import br.com.cmdev.solidcomjava.service.ReajusteService;
import br.com.cmdev.solidcomjava.validate.ValidacaoPercentualReajuste;
import br.com.cmdev.solidcomjava.validate.ValidacaoPeriodicidadeReajuste;
import br.com.cmdev.solidcomjava.validate.ValidacaoReajuste;

class FuncionarioTest {
	
	private List<ValidacaoReajuste> validacoes;
	
	@BeforeEach
	public void setUp() {
		this.validacoes = new ArrayList<ValidacaoReajuste>();
		validacoes.add(new ValidacaoPercentualReajuste());
		validacoes.add(new ValidacaoPeriodicidadeReajuste());
	}

	@Test
	void deveriaAumentarOSalarioDeUmFuncionarioComAcressimoDe100Reais() {
		Funcionario funcionario = new Funcionario("Calixto Macedo", "123654789741", Cargo.ESPECIALISTA, new BigDecimal("250.00"));
		funcionario.setDataUltimoReajuste(LocalDate.of(2020, 07, 01));
		new ReajusteService(validacoes).reajustarSalarioDoFuncionario(funcionario, new BigDecimal("100.00"));
		assertEquals( new BigDecimal("350.00"), funcionario.getSalario());
	}

	@Test
	void deveriaNaoPassarPeloValidacaoException() {
		Funcionario funcionario = new Funcionario("Calixto Macedo", "123654789741", Cargo.ESPECIALISTA, new BigDecimal("150.00"));
		funcionario.setDataUltimoReajuste(LocalDate.of(2020, 07, 01));
		assertThrows(ValidacaoException.class, () -> {
			new ReajusteService(validacoes).reajustarSalarioDoFuncionario(funcionario, new BigDecimal("100.00"));
		});
	}
	
}
