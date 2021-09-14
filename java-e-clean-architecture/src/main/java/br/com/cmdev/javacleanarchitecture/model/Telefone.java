package br.com.cmdev.javacleanarchitecture.model;

public class Telefone {

	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		if(numero == null || numero.isBlank() || ddd == null || ddd.isBlank()) {
			throw new IllegalArgumentException("DDD e Numero sao obrigatorios");
		}
		if(!ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD invalido");
		}
		if(!numero.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("numero invalido");
		}
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}
	
}
