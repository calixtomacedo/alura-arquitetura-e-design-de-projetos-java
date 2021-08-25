package br.com.cmdev.designpatternsii.service;

import br.com.cmdev.designpatternsii.model.Orsamento;
import br.com.cmdev.designpatternsii.service.impl.StatusOrsamento;

/**
 * Aplicando o pattern State
 */
public class Reprovado extends StatusOrsamento {

	@Override
	public void finalizar(Orsamento orsamento) {
		orsamento.setStatus(new Finalizado());
	}
}
