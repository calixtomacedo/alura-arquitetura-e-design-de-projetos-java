package br.com.cmdev.domaindrivendesign.escola.aplicacao.aluno.matricular;

import br.com.cmdev.domaindrivendesign.escola.dominio.PublicadorDeEventos;
import br.com.cmdev.domaindrivendesign.escola.dominio.RepositorioDeAlunos;
import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.Aluno;
import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.AlunoMatriculado;

public class MatricularAluno {

	private final RepositorioDeAlunos repositorio;
	private final PublicadorDeEventos publicador;

	public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
		this.repositorio = repositorio;
		this.publicador = publicador;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicador.publicar(evento);
	}

	
}
