package com.bhawnagunwani.models;

public class Product {

	private int id;
	private String name;
	private float price;
	private Brand brand;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, float price, Brand brand) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + "]";
	}

}
