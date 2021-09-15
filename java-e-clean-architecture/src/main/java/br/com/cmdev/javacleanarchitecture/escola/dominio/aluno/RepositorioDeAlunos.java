package br.com.cmdev.javacleanarchitecture.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {

	public void matricular(Aluno aluno);

	public Aluno buscarPorCPF(CPF cpf);
	
	public List<Aluno> listarTodosAlunosMatriculados();
	
}
