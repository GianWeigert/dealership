package br.com.gianweigert.dealership.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gianweigert.dealership.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
	
}
