package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import com.nespresso.ecommerce.mosaic.storefront.security.auth.presenters.Presenter;

public class AirConditioner {

	private final City city;
	private final double temperature;
	private final AirConditionerState state;
	private final Presenter presenter;
	
	public AirConditioner(String city, Presenter presenter) {
		this (City.valueOf(city), presenter, 0, new StoppedAirConditionerState());
	}
	
	private AirConditioner (City city, Presenter presenter, double temperature, AirConditionerState state)
	{
		this.city = city;
		this.presenter = presenter;
		this.state = state;
		this.temperature = temperature;
	}
	
	public AirConditioner stop ()
	{
		final AirConditionerState previousState = state;
		
		final AirConditionerState nextState = state.stop(presenter);
		
		if (nextState != previousState)
		{
			return new AirConditioner(city, presenter, temperature, nextState);
		}
		else
		{
			return this;
		}
	}
	
	public AirConditioner start ()
	{
		final AirConditionerState previousState = state;
		
		final AirConditionerState nextState = state.start(presenter);
		
		if (nextState != previousState)
		{
			return new AirConditioner(city, presenter, city.getTemperature(), nextState);
		}
		else
		{
			return this;
		}
	}

	public City getCity() {
		return city;
	}
	
	public Presenter getPresenter() {
		return presenter;
	}
	
	public void displayTemperature ()
	{
		state.displayTemperature(temperature, presenter);
	}
	
	public AirConditioner increase (final double increment)
	{
		final double newTemperature = state.increase(temperature, increment, presenter);
		
		if (temperature == newTemperature)
		{
			return this;
		}
		else
		{
			return new AirConditioner(city, presenter, newTemperature, state);
		}
	}
	
	public AirConditioner decrease (final double increment)
	{
		final double newTemperature = state.decrease(temperature, increment, presenter);
		
		if (temperature == newTemperature)
		{
			return this;
		}
		else
		{
			return new AirConditioner(city, presenter, newTemperature, state);
		}
	}
	
}
