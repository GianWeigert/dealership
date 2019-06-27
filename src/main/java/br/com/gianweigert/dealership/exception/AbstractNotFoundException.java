package br.com.gianweigert.dealership.exception;

@SuppressWarnings("serial")
abstract class AbstractNotFoundException extends RuntimeException {

	public AbstractNotFoundException(String message) {
		super(message);
	}
}
