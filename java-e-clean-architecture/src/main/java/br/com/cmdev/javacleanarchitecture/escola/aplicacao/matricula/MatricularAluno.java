package br.com.cmdev.javacleanarchitecture.escola.aplicacao.matricula;

import br.com.cmdev.javacleanarchitecture.escola.dominio.RepositorioDeAlunos;
import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.Aluno;

public class MatricularAluno {

	private final RepositorioDeAlunos repositorio;

	public MatricularAluno(RepositorioDeAlunos repositorio) {
		this.repositorio = repositorio;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
	}

	
}
