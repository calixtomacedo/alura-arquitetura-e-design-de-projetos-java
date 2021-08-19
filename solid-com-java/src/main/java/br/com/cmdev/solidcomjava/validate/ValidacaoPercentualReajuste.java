package br.com.cmdev.solidcomjava.validate;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.solidcomjava.ValidacaoException;
import br.com.cmdev.solidcomjava.model.Funcionario;
import br.com.cmdev.solidcomjava.service.ValidacaoReajuste;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal valorAumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
	}

}
