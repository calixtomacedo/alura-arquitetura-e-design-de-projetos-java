package br.com.cmdev.solidcomjava.validate;

import java.math.BigDecimal;

import br.com.cmdev.solidcomjava.model.Funcionario;

public interface ValidacaoReajuste {
	public void validar(Funcionario funcionario, BigDecimal valorAumento);
}
