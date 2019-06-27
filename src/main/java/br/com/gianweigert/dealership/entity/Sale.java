package br.com.gianweigert.dealership.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sale")
public class Sale extends AbstractEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
	private List<Car> cars;
	
	public Sale() {
		super();
		this.cars = new ArrayList<Car>();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Car> getCars() {
		return this.cars;
	}
	
	public void addCar(Car car) {
		if (!this.cars.contains(car)) {
			this.cars.add(car);
		}
	}
	
	public void removeCar(Car car) {
		if (this.cars.contains(car)) {
			this.cars.remove(car);
		}
	}
}
