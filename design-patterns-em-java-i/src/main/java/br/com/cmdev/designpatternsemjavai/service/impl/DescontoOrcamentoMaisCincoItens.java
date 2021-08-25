package br.com.cmdev.designpatternsemjavai.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;

public class DescontoOrcamentoMaisCincoItens extends Desconto {

	public DescontoOrcamentoMaisCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1").setScale(2, RoundingMode.HALF_EVEN));
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getQuantidateItens() > 5;
	}

}
