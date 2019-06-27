package br.com.gianweigert.dealership.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gianweigert.dealership.entity.Model;

@Repository
public interface ModelRepository extends CrudRepository<Model, Integer> {

	List<Model> findByBrandId(Integer brandId);
	
}
