package br.com.gianweigert.dealership.exception;

@SuppressWarnings("serial")
public class ModelNotFoundException extends AbstractNotFoundException {
	
	public ModelNotFoundException(Integer id) {
		super("Could not find model with ID " + id);
	}

}
