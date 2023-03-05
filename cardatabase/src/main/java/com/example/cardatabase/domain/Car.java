package com.example.cardatabase.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long myid;
	private String brand, model, color, registerNumber;
	private int price, productionYear;
	public Car(){}
	
	public Car(String brand, String model, String color,
			String registerNumber, int productionYear, int price) {
			super();
			this.brand = brand;
			this.model = model;
			this.color = color;
			this.registerNumber = registerNumber;
			this.productionYear = productionYear;
			this.price = price;
			}

	public long getMyid() {
		return myid;
	}

	public void setMyid(long myid) {
		this.myid = myid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
}