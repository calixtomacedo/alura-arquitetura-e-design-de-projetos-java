package br.com.cmdev.leilao.builder;

import br.com.cmdev.leilao.model.Usuario;

public class UsuarioBuilder {

	private String nome;
	private String email;
	private String password;
	
	public UsuarioBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public UsuarioBuilder email(String email) {
		this.email = email;
		return this;
	}

	public UsuarioBuilder password(String password) {
		this.password = password;
		return this;
	}
	
	public Usuario create() {
		return new Usuario(nome, email, password);
	}
}
