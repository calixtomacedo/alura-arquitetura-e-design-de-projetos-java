package br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.Aluno;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.Email;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.CifradorDeSenhaComMD5;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;

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
