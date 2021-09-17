package br.com.cmdev.domaindrivendesign.escola.gamificacao.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio.RepositorioDeSelos;
import br.com.cmdev.domaindrivendesign.escola.gamificacao.dominio.Selo;
import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
		return this.selos.stream().filter(s -> s.getCpfDoAluno().equals(cpf)).collect(Collectors.toList());
	}
}
