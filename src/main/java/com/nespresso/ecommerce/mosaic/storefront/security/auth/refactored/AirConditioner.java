package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.time.Month;
import java.util.Calendar;

public class AirConditioner {

	private final static int CALENDAR_MONTH_FIELD = 2;

	private final City city;
	private final boolean isStarted;
	private final double temperature;
	private final Presenter presenter;
	
	public AirConditioner(final String city, final Presenter presenter)
	{
		this (City.fromString(city), false, presenter, 0.0D);
	}
	
	private AirConditioner (final City city, final boolean isStarted, final Presenter presenter, final double temperature)
	{
		this.city = city;
		this.isStarted = isStarted;
		this.presenter = presenter;
		this.temperature = temperature;
	}

	public City getCity() {
		return city;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public double getTemperature() {
		return temperature;
	}
	
	public Presenter getPresenter() {
		return presenter;
	}

	public void displayTemperature ()
	{
		String temperatureToDisplay = "Air Conditioner is stopped, temperature is unkown";
		
		if (isStarted)
		{
			temperatureToDisplay = String.format("Temperature is %.0f", temperature);
		}
		
		presenter.displayMessage(temperatureToDisplay);
	}
	
	public AirConditioner decrease (final double delta)
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.APRIL.getValue() && currentMonth <= Month.SEPTEMBER.getValue())
			{
				return new AirConditioner(city, isStarted, presenter, temperature - delta);
			}
			else
			{
				presenter.displayMessage("We are in warm season, you cannot decrease more temperature");
			}
		}
		else
		{
			presenter.displayMessage("Air Conditioner is not started, please start it and try again");
		}
		
		return this;
	}
	
	public AirConditioner increase (final double delta)
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.OCTOBER.getValue() || currentMonth <= Month.MARCH.getValue())
			{
				return new AirConditioner(city, isStarted, presenter, temperature + delta);
			}
			else
			{
				presenter.displayMessage("We are in cold season, you cannot increase more temperature");
			}
		}
		else
		{
			presenter.displayMessage("Air Conditioner is not started, please start it and try again");
		}
		
		return this;
	}
	
	public AirConditioner start ()
	{
		if (!isStarted)
		{
			return new AirConditioner(city, !isStarted, presenter, city.getTemperature());
		}
		else
		{
			presenter.displayMessage("Air Conditioner is already started, we are doing nothing");
			return this;
		}
	}
	
	public AirConditioner stop ()
	{
		if (!isStarted)
		{
			presenter.displayMessage("Air Conditioner is already stopped, we are doing nothing");
			return this;
		}
		else
		{
			return new AirConditioner(city, !isStarted, presenter, 0.0D);
		}
	}
}
