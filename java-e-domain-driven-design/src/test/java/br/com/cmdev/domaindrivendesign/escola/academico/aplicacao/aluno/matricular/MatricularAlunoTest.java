package br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.Aluno;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.cmdev.domaindrivendesign.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.PublicadorDeEventos;

class MatricularAlunoTest {

	//private Connection connection;
	
	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> Mockito
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

		MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-00", "fulano@email.com", "123456");
		useCase.executa(dados);

		Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}
/*
	@Test
	void alunoDeveriaSerPersistidoComJDBC() {
		// MOCK -> Mockito
		RepositorioDeAlunosComJDBC repositorio = new RepositorioDeAlunosComJDBC(connection);
		MatricularAluno useCase = new MatricularAluno(repositorio);

		MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-00", "fulano@email.com", "123456");
		useCase.executa(dados);

		Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}
*/
}
