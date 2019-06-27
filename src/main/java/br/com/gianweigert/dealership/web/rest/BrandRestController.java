package br.com.gianweigert.dealership.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianweigert.dealership.entity.Brand;
import br.com.gianweigert.dealership.entity.Model;
import br.com.gianweigert.dealership.entity.groups.StoreBrandGroup;
import br.com.gianweigert.dealership.exception.BrandNotFoundException;
import br.com.gianweigert.dealership.service.BrandService;
import br.com.gianweigert.dealership.service.ModelService;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ModelService modelService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Brand> getAll() {
		return this.brandService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Brand getOne(@PathVariable Integer id) {
		return this.brandService.findOne(id)
				.orElseThrow(() -> new BrandNotFoundException(id));
	}

	@GetMapping("/{id}/models")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Model> findModelsOfABrand(@PathVariable Integer id) {
		return this.modelService.findByBrandId(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Brand create(@Validated(value = StoreBrandGroup.class) @RequestBody Brand brand) {
		return this.brandService.save(brand);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Brand edit(@PathVariable Integer id, @RequestBody Brand brand) {
		return this.brandService.update(id, brand);
	}

}
