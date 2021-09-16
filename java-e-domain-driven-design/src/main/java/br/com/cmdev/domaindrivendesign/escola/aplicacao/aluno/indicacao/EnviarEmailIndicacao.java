package br.com.cmdev.domaindrivendesign.escola.aplicacao.aluno.indicacao;

import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	public void enviarPara(Aluno indicacao);
	
}
