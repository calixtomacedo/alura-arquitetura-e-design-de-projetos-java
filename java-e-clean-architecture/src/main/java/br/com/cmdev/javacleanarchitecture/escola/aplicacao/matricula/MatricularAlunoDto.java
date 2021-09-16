package br.com.cmdev.javacleanarchitecture.escola.aplicacao.matricula;

import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.Aluno;
import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.CPF;
import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.Email;
import br.com.cmdev.javacleanarchitecture.escola.infra.CifradorDeSenhaComMD5;

public class MatricularAlunoDto {

	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	private String senha;

	public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno, String senha) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
		this.senha = senha;
	}

	public Aluno criarAluno() {
		return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno), new CifradorDeSenhaComMD5().cifrarSenha(senha));
	}

}
