package br.com.cmdev.javacleanarchitecture.escola.dominio;

public interface CifradorDeSenha {

	public String cifrarSenha(String senha);
	
	public boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
