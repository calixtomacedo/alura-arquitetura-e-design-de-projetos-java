package br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.Evento;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

	public void reageAo(Evento evento) {
		String momento = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		System.out.println(String.format("Aluno com CPF: %s matriculado em: %s", ((AlunoMatriculado) evento).getCpfDoAluno().getNumero(), momento));
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}
	
}
