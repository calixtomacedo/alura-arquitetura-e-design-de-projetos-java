package br.com.cmdev.designpatternsii.service;

import java.util.Map;

import br.com.cmdev.designpatternsii.DomainException;
import br.com.cmdev.designpatternsii.http.HttpAdapter;
import br.com.cmdev.designpatternsii.model.Orsamento;

/**
 * Aplicando o pattern Adapter
 */
public class RegistroDeOrsamento {
	
	private HttpAdapter http;
	

	public RegistroDeOrsamento(HttpAdapter http) {
		this.http = http;
	}


	public void registrar(Orsamento orsamento) {
		if(!orsamento.isFinalizado()) {
			throw new DomainException("Orsamento não finalizado!");
		}
		
		String url = "http://api.externa/orsamento";
		Map<String, Object> dados = Map.of("Valor", orsamento.getValor(), "qantidateItens", orsamento.getQuantidateItens());
		
		http.post(url, dados);
	}
}
