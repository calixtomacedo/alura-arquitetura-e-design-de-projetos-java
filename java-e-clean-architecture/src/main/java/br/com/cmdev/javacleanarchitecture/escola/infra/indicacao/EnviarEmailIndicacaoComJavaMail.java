package br.com.cmdev.javacleanarchitecture.escola.infra.indicacao;

import br.com.cmdev.javacleanarchitecture.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.cmdev.javacleanarchitecture.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicacao) {
		// Logica de envio de email com a lib Java Mail
	}

}
