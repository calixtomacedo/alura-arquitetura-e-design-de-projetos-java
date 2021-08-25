package br.com.cmdev.designpatternsii;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 5961686450439092228L;

	public DomainException(String message) {
		super(message);
	}

}
