package br.com.cmdev.designpatternsii.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.cmdev.designpatternsii.model.ItemOrcamento;
import br.com.cmdev.designpatternsii.model.Orcamento;
import br.com.cmdev.designpatternsii.model.OrcamentoProxy;

/**
 * Aplicando o pattern Composite
 */
class ComposicaoOrcamentoTest {

	@Test
	void testComposicao() {
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		antigo.reprovar();
		
		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);
		
		/**
		 * Aplicando o pattern Proxy
		 */
		
		OrcamentoProxy proxy = new OrcamentoProxy(novo); 
		
		System.out.println("Valor orçamento: "+proxy.getValor());
		System.out.println("Valor orçamento: "+proxy.getValor());
		
		assertEquals(new BigDecimal("700"), novo.getValor());
	}

}
