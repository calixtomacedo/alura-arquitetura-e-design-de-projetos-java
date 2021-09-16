package br.com.cmdev.domaindrivendesign.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.Aluno;
import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.CPF;
import br.com.cmdev.domaindrivendesign.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	//private Connection connection;
	
	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> Mockito
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);

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
