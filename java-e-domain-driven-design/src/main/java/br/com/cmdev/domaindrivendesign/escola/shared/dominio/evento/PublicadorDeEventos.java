package br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {

	private List<Ouvinte> ouvintes = new ArrayList<>();
	
	public void adicionar(Ouvinte ouvinte) {
		this.ouvintes.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		this.ouvintes.forEach(ouvinte -> ouvinte.processa(evento));
	}
	
}
