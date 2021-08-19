package br.com.cmdev.solidcomjava;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = -1486128079823240588L;
	
	public ValidacaoException(String mensagem) {
		super(mensagem);
	}
}
