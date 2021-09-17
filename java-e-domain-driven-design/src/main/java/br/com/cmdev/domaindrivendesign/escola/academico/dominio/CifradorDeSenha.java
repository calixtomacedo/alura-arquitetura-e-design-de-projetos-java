package br.com.cmdev.domaindrivendesign.escola.academico.dominio;

public interface CifradorDeSenha {

	public String cifrarSenha(String senha);
	
	public boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
