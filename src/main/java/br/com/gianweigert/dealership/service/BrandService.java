package br.com.gianweigert.dealership.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gianweigert.dealership.entity.Brand;
import br.com.gianweigert.dealership.repository.BrandRepository;

@Service
public class BrandService {

	private BrandRepository repository;

	public BrandService(BrandRepository brandRepository) {
		this.repository = brandRepository;
	}

	public Iterable<Brand> findAll() {
		return this.repository.findAll();
	}

	public Optional<Brand> findOne(Integer id) {
		return repository.findById(id);
	}

	public Brand save(Brand brand) {
		return this.repository.save(brand);
	}

	public Brand update(Integer id, Brand brand) {
		return repository.findById(id).map(oldBrand -> {
			oldBrand.setName(brand.getName());
			oldBrand.setUpdatedAt(new Date());
			return repository.save(oldBrand);
		}).orElseGet(() -> {
			brand.setId(id);
			return repository.save(brand);
		});
	}
}
