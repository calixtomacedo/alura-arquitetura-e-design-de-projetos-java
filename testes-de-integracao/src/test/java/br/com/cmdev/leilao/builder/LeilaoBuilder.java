package br.com.cmdev.leilao.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.cmdev.leilao.model.Leilao;
import br.com.cmdev.leilao.model.Usuario;

public class LeilaoBuilder {
	
	private String nome;
	private BigDecimal valorInicial;
	private LocalDate data;
	private Usuario usuario;
	
	public LeilaoBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public LeilaoBuilder valorInicial(String valor) {
		this.valorInicial = new BigDecimal(valor);
		return this;
	}
	
	public LeilaoBuilder data(LocalDate data) {
		this.data = data;
		return this;
	}
	
	public LeilaoBuilder usuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public Leilao create() {
		return new Leilao(nome, valorInicial, data, usuario);
	}

}
