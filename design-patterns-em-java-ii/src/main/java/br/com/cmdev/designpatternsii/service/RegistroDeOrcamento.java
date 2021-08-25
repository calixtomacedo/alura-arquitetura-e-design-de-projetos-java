package br.com.cmdev.designpatternsii.service;

import java.util.Map;

import br.com.cmdev.designpatternsii.DomainException;
import br.com.cmdev.designpatternsii.http.HttpAdapter;
import br.com.cmdev.designpatternsii.model.Orcamento;

/**
 * Aplicando o pattern Adapter
 */
public class RegistroDeOrcamento {
	
	private HttpAdapter http;
	

	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}


	public void registrar(Orcamento orcamento) {
		if(!orcamento.isFinalizado()) {
			throw new DomainException("Orcamento não finalizado!");
		}
		
		String url = "http://api.externa/Orcamento";
		Map<String, Object> dados = Map.of("Valor", orcamento.getValor(), "qantidateItens", orcamento.getQuantidateItens());
		
		http.post(url, dados);
	}
}
