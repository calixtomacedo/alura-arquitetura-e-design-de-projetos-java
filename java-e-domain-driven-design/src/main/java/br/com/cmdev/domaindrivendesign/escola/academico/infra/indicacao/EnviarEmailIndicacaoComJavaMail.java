package br.com.cmdev.domaindrivendesign.escola.academico.infra.indicacao;

import br.com.cmdev.domaindrivendesign.escola.academico.aplicacao.aluno.indicacao.EnviarEmailIndicacao;
import br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicacao) {
		// Logica de envio de email com a lib Java Mail
	}

}
