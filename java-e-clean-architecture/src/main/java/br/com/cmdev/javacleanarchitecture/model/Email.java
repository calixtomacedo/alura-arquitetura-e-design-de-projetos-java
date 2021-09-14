package br.com.cmdev.javacleanarchitecture.model;

public class Email {
	
	// VALUE OBJECT
	
	private String endereco;

	public Email(String endereco) {
		if(endereco == null || endereco.isBlank() || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail invalido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

}
