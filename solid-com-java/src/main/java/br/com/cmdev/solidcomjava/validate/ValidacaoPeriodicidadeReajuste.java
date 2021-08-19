package br.com.cmdev.solidcomjava.validate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.cmdev.solidcomjava.ValidacaoException;
import br.com.cmdev.solidcomjava.model.Funcionario;
import br.com.cmdev.solidcomjava.service.ValidacaoReajuste;

public class ValidacaoPeriodicidadeReajuste implements ValidacaoReajuste {

	@Override
	public void validar(Funcionario funcionario, BigDecimal valorAumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		if(mesesDesdeUltimoReajuste < 6) {
			throw new ValidacaoException("O intervalo entre reajustes deve ser de no mínimo 6 meses!");
		}
	}

}
