package br.com.gianweigert.dealership.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gianweigert.dealership.entity.Brand;
import br.com.gianweigert.dealership.entity.Model;
import br.com.gianweigert.dealership.exception.BrandNotFoundException;
import br.com.gianweigert.dealership.repository.BrandRepository;
import br.com.gianweigert.dealership.repository.ModelRepository;

@Service
public class ModelService {

	private ModelRepository modelRepository;
	private BrandRepository brandRepository;

	public ModelService(ModelRepository modelRepository, BrandRepository brandRepository) {
		this.modelRepository = modelRepository;
		this.brandRepository = brandRepository;
	}

	public Iterable<Model> findAll() {
		return this.modelRepository.findAll();
	}

	public Optional<Model> findOne(Integer id) {
		return this.modelRepository.findById(id);
	}

	public List<Model> findByBrandId(Integer brandId) {
		return this.modelRepository.findByBrandId(brandId);
	}
	
	public Model insert(Model model) {
		Brand brand = this.getBrand(model.getBrand().getId());
		model.setBrand(brand);
		return this.modelRepository.save(model);
	}

	public Model update(Integer id, Model model) {
		Brand brand = this.getBrand(model.getBrand().getId());

		return this.modelRepository.findById(id).map(oldModel -> {
			oldModel.setName(model.getName());
			oldModel.setUpdatedAt(new Date());
			oldModel.setBrand(brand);
			return this.modelRepository.save(oldModel);
		}).orElseGet(() -> {
			model.setId(id);
			model.setBrand(brand);
			return this.modelRepository.save(model);
		});
	}

	public void delete(Integer id) {
		this.modelRepository.deleteById(id);
	}

	private Brand getBrand(Integer id) {
		return this.brandRepository.findById(id)
				.orElseThrow(() -> new BrandNotFoundException(id));
	}

}
