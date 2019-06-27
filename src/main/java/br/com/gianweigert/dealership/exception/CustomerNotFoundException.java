package br.com.gianweigert.dealership.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends AbstractNotFoundException {
	
	public CustomerNotFoundException(Integer id) {
		super("Could not found the customer with id " + id);
	}
}
