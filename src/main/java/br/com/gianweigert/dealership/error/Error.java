package br.com.gianweigert.dealership.error;

public class Error {
	private String message;
	
	public Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
