package br.com.gianweigert.dealership.service;

import org.springframework.stereotype.Service;

import br.com.gianweigert.dealership.entity.Customer;
import br.com.gianweigert.dealership.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Iterable<Customer> findAll() {
		return this.customerRepository.findAll();
	}
	
	public Customer finOne(Integer id) {
		
		//this.customerRepository.findById(id).orElseThrow(())
		
		return null;
	}
}
