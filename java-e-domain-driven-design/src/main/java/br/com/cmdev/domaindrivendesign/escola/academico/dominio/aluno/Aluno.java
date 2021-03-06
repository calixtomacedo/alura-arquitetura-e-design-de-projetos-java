package br.com.cmdev.domaindrivendesign.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.cmdev.domaindrivendesign.escola.shared.dominio.CPF;

public class Aluno {
	
	private CPF cpf; 
	private String nome;
	private Email email;
	private String senha;
	private List<Telefone> telefones = new ArrayList<>();
	
	public Aluno(CPF cpf, String nome, Email email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public void adicionarTelefone(String ddd, String numero) {
		if(this.telefones.size() == 2) {
			throw new IllegalArgumentException("É permitido cadastrar apenas 2 telefones!"); 
		}
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}
	
	public String getSenha() {
		return senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
}
