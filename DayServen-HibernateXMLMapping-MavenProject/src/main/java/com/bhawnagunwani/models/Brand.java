package com.bhawnagunwani.models;

import java.util.Set;

public class Brand {

	private int id;
	private String name;
	private Set<Product> products;
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(String name) {
		super();
		this.name = name;
	}

	public Brand(String name, Set<Product> products) {
		super();
		this.name = name;
		this.products = products;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + "]";
	}

}
