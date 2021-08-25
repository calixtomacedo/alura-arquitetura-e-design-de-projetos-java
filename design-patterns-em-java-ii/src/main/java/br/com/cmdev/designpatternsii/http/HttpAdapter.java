package br.com.cmdev.designpatternsii.http;

import java.util.Map;

/**
 * Aplicando o pattern Adapter
 */
public interface HttpAdapter {

	public void post(String url, Map<String, Object> dados);
	
}
