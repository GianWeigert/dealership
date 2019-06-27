package br.com.gianweigert.dealership.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.gianweigert.dealership.entity.Car;
import br.com.gianweigert.dealership.entity.Model;
import br.com.gianweigert.dealership.exception.ModelNotFoundException;
import br.com.gianweigert.dealership.repository.CarRepository;
import br.com.gianweigert.dealership.repository.ModelRepository;

@Service
public class CarService {

	private CarRepository carRepository;
	private ModelRepository modelRepository;
	
	public CarService(CarRepository carRepository, ModelRepository modelRepository) {
		this.carRepository = carRepository;
		this.modelRepository = modelRepository;
	}
	
	public Iterable<Car> fetchAll() {
		return this.carRepository.findAll();
	}
	
	public Optional<Car> findOne(Integer id) {
		return this.carRepository.findById(id);
	}
	
	public Car insert(Car car) {
		Model model = this.findModel(car.getModel().getId());
		car.setModel(model);
		return this.carRepository.save(car);
	}
	
	public Car update(Integer id, Car car) {
		Model model = this.findModel(car.getModel().getId()); 
		System.out.println(car.getLicensePlate());
		return this.carRepository.findById(id).map(oldCar -> {
			oldCar.setKilometers(car.getKilometers());
			oldCar.setLicensePlate(car.getLicensePlate());
			oldCar.setPrice(car.getPrice());
			oldCar.setEnabled(car.isEnabled());
			oldCar.setUpdatedAt(new Date());
			oldCar.setModel(model);
			return this.carRepository.save(oldCar);
		})
		.orElseGet(() -> {
			car.setId(id);
			car.setModel(model);
			return this.carRepository.save(car);
		});
	}
	
	public Model findModel(Integer id) {
		return this.modelRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException(id));
	}
}
