package br.com.gianweigert.dealership.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianweigert.dealership.entity.Customer;
import br.com.gianweigert.dealership.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	public Iterable<Customer> getAll() {
		return this.customerService.findAll();
	}
}
