package br.com.cmdev.solidcomjava.model;

import java.math.BigDecimal;

public class Terceirizado extends Funcionario {

	private String nomeEmpresa;

	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		super(nome, cpf, cargo, salario);
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

}
