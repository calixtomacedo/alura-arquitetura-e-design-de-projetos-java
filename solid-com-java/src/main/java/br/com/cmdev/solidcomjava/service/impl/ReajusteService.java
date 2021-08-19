package br.com.cmdev.solidcomjava.service.impl;

import java.math.BigDecimal;
import java.util.List;

import br.com.cmdev.solidcomjava.model.Funcionario;
import br.com.cmdev.solidcomjava.service.ValidacaoReajuste;

public class ReajusteService {
	
	private List<ValidacaoReajuste> validacaoes;

	public ReajusteService(List<ValidacaoReajuste> validacaoes) {
		this.validacaoes = validacaoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento) {
		
		this.validacaoes.forEach(validacao -> validacao.validar(funcionario, valorAumento));
		
		BigDecimal salarioReajustado = funcionario.getSalario().add(valorAumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
