package br.com.cmdev.domaindrivendesign.escola.academico;

import br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.PublicadorDeEventos;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.CifradorDeSenhaComMD5;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {

	public static void main(String[] args) {
		String nome = "Fulano da Silva";
		String cpf = "123.456.789-00";
		String email = "fulano@email.com";
		String senha = new CifradorDeSenhaComMD5().cifrarSenha("123456");

		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
		matricular.executa(new MatricularAlunoDto(nome, cpf, email, senha));
		
	}

}
