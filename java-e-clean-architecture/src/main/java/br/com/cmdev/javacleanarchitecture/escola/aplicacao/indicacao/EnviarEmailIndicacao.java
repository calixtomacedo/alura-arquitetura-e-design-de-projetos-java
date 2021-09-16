package br.com.cmdev.javacleanarchitecture.escola.aplicacao.indicacao;

import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	public void enviarPara(Aluno indicacao);
	
}
