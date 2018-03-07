package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public abstract class AirConditioner {
	
	final static int CALENDAR_MONTH_FIELD = 2;

	final City city;
	final double temperature;
	final Presenter presenter;
	
	AirConditioner (final City city, final Presenter presenter, final double temperature)
	{
		this.city = city;
		this.presenter = presenter;
		this.temperature = temperature;
	}
	
	AirConditioner (final String city, final Presenter presenter, final double temperature)
	{
		this (City.fromString(city), presenter, temperature);
	}

	public City getCity() {
		return city;
	}

	public double getTemperature() {
		return temperature;
	}
	
	public Presenter getPresenter() {
		return presenter;
	}

	public abstract void displayTemperature ();
	
	public abstract AirConditioner decrease (final double delta);
	
	public abstract AirConditioner increase (final double delta);
}
