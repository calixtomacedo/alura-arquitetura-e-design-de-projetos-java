package br.com.cmdev.javacleanarchitecture.escola;

import br.com.cmdev.javacleanarchitecture.escola.aplicacao.matricula.MatricularAluno;
import br.com.cmdev.javacleanarchitecture.escola.aplicacao.matricula.MatricularAlunoDto;
import br.com.cmdev.javacleanarchitecture.escola.infra.CifradorDeSenhaComMD5;
import br.com.cmdev.javacleanarchitecture.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		String senha = new CifradorDeSenhaComMD5().cifrarSenha("123456");

		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		matricular.executa(new MatricularAlunoDto(nome, cpf, email, senha));

	}

}
