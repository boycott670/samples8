package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.time.Month;
import java.util.Calendar;

public class AirConditioner {

	public AirConditioner(final String city)
	{
		this.city = City.fromString(city);
		manufacturer = new Manufacturer();
	}

	private final City city;
	private final Manufacturer manufacturer;
	
	private boolean isStarted = false;
	private double temperature = 0.0D;
	
	private final Presenter presenter = new DefaultPresenter();
	
	private final static int CALENDAR_MONTH_FIELD = 2;

	public City getCity() {
		return city;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public double getTemperature() {
		return temperature;
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
	
	public void decrease (final double delta)
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.APRIL.getValue() && currentMonth <= Month.SEPTEMBER.getValue())
			{
				temperature -= delta;
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
	}
	
	public void increase (final double delta)
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.OCTOBER.getValue() || currentMonth <= Month.MARCH.getValue())
			{
				temperature += delta;
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
	}
	
	public void start ()
	{
		if (!isStarted)
		{
			isStarted = true;
			this.temperature = city.getTemperature();
		}
		else
		{
			presenter.displayMessage("Air Conditioner is already started, we are doing nothing");
		}
	}
	
	public void stop ()
	{
		if (!isStarted)
		{
			presenter.displayMessage("Air Conditioner is already stopped, we are doing nothing");
		}
		else
		{
			isStarted = false;
			temperature = 0.0D;
		}
	}
}
