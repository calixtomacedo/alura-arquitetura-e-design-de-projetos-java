package br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio;

import java.util.List;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.CPF;

public interface RepositorioDeSelos {

	public void adicionar(Selo selo);
	
	public List<Selo> selosDoAlunoDeCPF(CPF cpf);
	
}
