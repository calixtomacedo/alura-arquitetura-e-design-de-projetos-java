package br.com.cmdev.domaindrivendesign.escola.infra.indicacao;

import br.com.cmdev.domaindrivendesign.escola.aplicacao.aluno.indicacao.EnviarEmailIndicacao;
import br.com.cmdev.domaindrivendesign.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicacao) {
		// Logica de envio de email com a lib Java Mail
	}

}
