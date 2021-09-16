package br.com.cmdev.domaindrivendesign.escola.dominio;

import java.util.List;

import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.Aluno;
import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.CPF;

public interface RepositorioDeAlunos {

	public void matricular(Aluno aluno);

	public Aluno buscarPorCPF(CPF cpf);
	
	public List<Aluno> listarTodosAlunosMatriculados();
	
}
