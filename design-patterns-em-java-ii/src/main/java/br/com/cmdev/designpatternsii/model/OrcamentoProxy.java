package br.com.cmdev.designpatternsii.model;

import java.math.BigDecimal;

/**
 * Aplicando o pattern Proxy
 */
public class OrcamentoProxy extends Orcamento {

	private BigDecimal valor;
	private Orcamento orcamento;
	
	public OrcamentoProxy(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	@Override
	public BigDecimal getValor() {
		if(valor == null) {
			this.valor = orcamento.getValor();
		}
		return this.valor;
	}
}
