package br.com.gianweigert.dealership.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gianweigert.dealership.types.CarType;

@Entity
@Table(name = "car")
public class Car extends AbstractEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "license_plate", unique = true, nullable = false)
	private String licensePlate;

	@Column(name = "price", nullable = false)
	private Double price;

	@Column(name = "kilometers", nullable = false)
	private Double kilometers;

	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	private Model model;

	@ManyToOne
	@JoinColumn(name = "sale_id", nullable = false)
	private Sale sale;

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private CarType type;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getKilometers() {
		return this.kilometers;
	}

	public void setKilometers(Double kilometers) {
		this.kilometers = kilometers;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

}
