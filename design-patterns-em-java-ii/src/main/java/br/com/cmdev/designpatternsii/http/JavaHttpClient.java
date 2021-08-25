package br.com.cmdev.designpatternsii.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Aplicando o pattern Adapter
 */
public class JavaHttpClient implements HttpAdapter {

	@Override
	public void post(String url, Map<String, Object> dados) {

		try {
			URL uri = new URL(url);
			URLConnection connection = uri.openConnection();
			connection.connect();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao enviar a requesição HTTP ", e);
		}
		
	}

}
