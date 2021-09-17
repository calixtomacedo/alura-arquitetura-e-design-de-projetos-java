package br.com.cmdev.domaindrivendesign.escola.gamificacao.aplicacao;

import br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio.RepositorioDeSelos;
import br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio.Selo;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.Evento;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.Ouvinte;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

	private final RepositorioDeSelos repositorio;
	
	public GeraSeloAlunoNovato(RepositorioDeSelos repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
	}

	@Override
	protected void reageAo(Evento evento) {
		CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
		Selo novato = new Selo(cpfDoAluno, "Novato");
		repositorio.adicionar(novato);
	}

}
