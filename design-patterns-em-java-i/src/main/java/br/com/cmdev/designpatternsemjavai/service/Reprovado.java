package br.com.cmdev.designpatternsemjavai.service;

import br.com.cmdev.designpatternsemjavai.model.Orcamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrcamento;

/**
 * Aplicando o pattern State
 */
public class Reprovado extends StatusOrcamento {

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setStatus(new Finalizado());
	}
}
