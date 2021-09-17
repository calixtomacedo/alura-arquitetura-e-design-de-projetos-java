package br.com.cmdev.domaindrivendesign.escola;

import br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.CifradorDeSenhaComMD5;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.cmdev.domaindrivendesign.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.cmdev.domaindrivendesign.escola.gamificacao.infra.RepositorioDeSelosEmMemoria;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {

	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		String senha = new CifradorDeSenhaComMD5().cifrarSenha("123456");

		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
		matricular.executa(new MatricularAlunoDto(nome, cpf, email, senha));
		
	}

}
