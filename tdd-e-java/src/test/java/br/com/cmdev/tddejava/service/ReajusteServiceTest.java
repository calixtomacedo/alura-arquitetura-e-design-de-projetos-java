package br.com.cmdev.tddejava.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cmdev.tddejava.model.Desempenho;
import br.com.cmdev.tddejava.model.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("ISSO SERÁ EXECUTANDO DEPOIS DE TUDO");
	}
	
	@AfterEach
	public void depoisDeCadaTeste() {
		System.out.println("ISSO SERÁ EXECUTANDO DEPOIS DE CADA TESTE");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ISSO SERÁ EXECUTANDO ANTES DE TUDO");
	}
	
	@BeforeEach
	public void inicializar() {
		System.out.println("ISSO SERÁ EXECUTANDO ANTES DE CADA TESTE");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("José", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.consederReajuste(funcionario, Desempenho.ADESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		service.consederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
		service.consederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
