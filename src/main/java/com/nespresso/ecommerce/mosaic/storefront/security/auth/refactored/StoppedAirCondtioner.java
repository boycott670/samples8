package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

public class StoppedAirCondtioner extends AirConditioner {

	public StoppedAirCondtioner (final String city, final Presenter presenter)
	{
		super (City.fromString(city), presenter, 0.0D);
	}
	
	StoppedAirCondtioner (final City city, final Presenter presenter, final double temperature)
	{
		super (city, presenter, temperature);
	}

	@Override
	public void displayTemperature() {
		presenter.displayMessage("Air Conditioner is stopped, temperature is unkown");
	}

	@Override
	public StoppedAirCondtioner decrease(double delta)
	{
		presenter.displayMessage("Air Conditioner is not started, please start it and try again");
		
		return this;
	}

	@Override
	public AirConditioner increase(double delta) {

		presenter.displayMessage("Air Conditioner is not started, please start it and try again");
		
		return this;
		
	}

	public StartedAirConditioner start() {

		return new StartedAirConditioner(city, presenter, city.getTemperature());
		
	}
}