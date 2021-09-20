package br.com.cmdev.tddejava.service;

import java.math.BigDecimal;

import br.com.cmdev.tddejava.model.Desempenho;
import br.com.cmdev.tddejava.model.Funcionario;

public class ReajusteService {

	public void consederReajuste(Funcionario funcionario, Desempenho desempenho) {

		BigDecimal percentual = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
		
		// Antes do Refactory
		/*
		if(desempenho.equals(Desempenho.ADESEJAR)) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
			funcionario.reajustarSalario(reajuste);
		}
		if(desempenho.equals(Desempenho.BOM)) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
			funcionario.reajustarSalario(reajuste);
		}
		if(desempenho.equals(Desempenho.OTIMO)) {
			BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
			funcionario.reajustarSalario(reajuste);
		}
		*/
	}
}
