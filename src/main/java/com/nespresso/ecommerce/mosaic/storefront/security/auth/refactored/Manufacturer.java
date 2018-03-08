package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public class Manufacturer {

	public Manufacturer() {
		this (null);
	}

	public Manufacturer(String name) {
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
