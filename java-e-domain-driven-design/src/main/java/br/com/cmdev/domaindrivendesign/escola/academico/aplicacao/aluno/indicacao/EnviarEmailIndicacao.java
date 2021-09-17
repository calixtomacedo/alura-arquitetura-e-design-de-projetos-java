package br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.indicacao;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	public void enviarPara(Aluno indicacao);
	
}
