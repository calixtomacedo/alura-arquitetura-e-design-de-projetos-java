package br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio;

import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;

public class Selo {

	private CPF cpfDoAluno;
	private String nome;
	
	public Selo(CPF cpfDoAluno, String nome) {
		this.cpfDoAluno = cpfDoAluno;
		this.nome = nome;
	}

	public CPF getCpfDoAluno() {
		return cpfDoAluno;
	}

	public String getNome() {
		return nome;
	}
	
}
