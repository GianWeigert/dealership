package br.com.gianweigert.dealership.exception;

@SuppressWarnings("serial")
public class BrandNotFoundException extends AbstractNotFoundException {
		   
	public BrandNotFoundException(Integer id) {
	    super("Could not find brand with ID " + id);
	}

}
