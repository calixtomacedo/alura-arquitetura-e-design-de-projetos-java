package br.com.cmdev.domaindrivendesign.escola.shared.dominio;

public class CPF {

	private String numero;

	public CPF(String numero) {
		if(numero == null || numero.isBlank() || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
	
}
