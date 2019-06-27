package br.com.gianweigert.dealership.exception;

@SuppressWarnings("serial")
public class CarNotFoundException extends AbstractNotFoundException {
		
	public CarNotFoundException(Integer id) {
		super("Could not find car with ID " + id);
	}
	
}
