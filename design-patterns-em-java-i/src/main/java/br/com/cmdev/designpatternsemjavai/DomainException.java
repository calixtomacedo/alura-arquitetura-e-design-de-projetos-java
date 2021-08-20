package br.com.cmdev.designpatternsemjavai;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 5961686450439092228L;

	public DomainException(String message) {
		super(message);
	}

}
