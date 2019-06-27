package br.com.gianweigert.dealership.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gianweigert.dealership.entity.Car;
import br.com.gianweigert.dealership.exception.CarNotFoundException;
import br.com.gianweigert.dealership.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Iterable<Car> getAll(){
		return this.carService.fetchAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Car getOne(@PathVariable Integer id) {
		return this.carService.findOne(id).
				orElseThrow(() -> new CarNotFoundException(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Car create(@RequestBody Car car) {
		return this.carService.insert(car);
	}
	
}
