package br.com.cmdev.designpatternsemjavai.service;

import br.com.cmdev.designpatternsemjavai.model.Orsamento;
import br.com.cmdev.designpatternsemjavai.service.impl.StatusOrsamento;

/**
 * Aplicando o pattern State
 */
public class Reprovado extends StatusOrsamento {

	@Override
	public void finalizar(Orsamento orsamento) {
		orsamento.setStatus(new Finalizado());
	}
}
