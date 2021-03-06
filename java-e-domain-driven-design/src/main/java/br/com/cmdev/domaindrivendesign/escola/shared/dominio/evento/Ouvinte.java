package br.com.cmdev.domaindrivendesign.escola.shared.dominio.evento;

public abstract class Ouvinte {

	public void processa(Evento evento) {
		if(this.deveProcessar(evento)) {
			this.reageAo(evento);
		}
	}

	protected abstract boolean deveProcessar(Evento evento);
	protected abstract void reageAo(Evento evento);
	
}
