package br.com.cmdev.designpatternsii.service;

import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.service.impl.StatusOrcamento;

/**
 * Aplicando o pattern State
 */
public class Reprovado extends StatusOrcamento {

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setStatus(new Finalizado());
	}
}
