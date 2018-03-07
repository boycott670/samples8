package com.nespresso.ecommerce.mosaic.storefront.security.auth.refactored;

import java.time.Month;
import java.util.Calendar;

public class AirConditioner {

	public AirConditioner(City city)
	{
		this.city = city;
		manufacturer = new Manufacturer();
	}

	private final City city;
	private final Manufacturer manufacturer;
	
	private boolean isStarted = false;
	private Temperature temperature = Temperature.LOW;
	
	private final static int CALENDAR_MONTH_FIELD = 2;

	public City getCity() {
		return city;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public Temperature getTemperature() {
		return temperature;
	}
	
	public void displayTemperature ()
	{
		String temperatureToDisplay = "Air Conditioner is stopped, temperature is unkown";
		
		if (isStarted)
		{
			String.format("Temperature is %s", temperature);
		}
		
		System.out.println(temperatureToDisplay);
	}
	
	public void decrease ()
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.APRIL.getValue() && currentMonth <= Month.SEPTEMBER.getValue())
			{
				temperature = temperature.getPrevious();
			}
			else
			{
				System.out.println("We are in warm season, you cannot decrease more temperature");
			}
		}
		else
		{
			System.out.println("Air Conditioner is not started, please start it and try again");
		}
	}
	
	public void increase ()
	{
		if (isStarted)
		{
			final int currentMonth = Calendar.getInstance().get(CALENDAR_MONTH_FIELD);
			
			if (currentMonth >= Month.OCTOBER.getValue() || currentMonth <= Month.MARCH.getValue())
			{
				temperature = temperature.getNext();
			}
			else
			{
				System.out.println("We are in cold season, you cannot increase more temperature");
			}
		}
		else
		{
			System.out.println("Air Conditioner is not started, please start it and try again");
		}
	}
	
	public void start ()
	{
		Temperature temperature = Temperature.LOW;
		
		switch (city)
		{
			case RABAT:
				temperature = Temperature.MEDIUM;
				break;
				
			case CASABLANCA:
				temperature = Temperature.ABOVE_MEDIUM;
				break;
				
			case AGADIR:
				temperature = Temperature.HIGH;
				break;
		}
		
		if (!isStarted)
		{
			isStarted = true;
			this.temperature = temperature;
		}
		else
		{
			System.out.println("Air Conditioner is already started, we are doing nothing");
		}
	}
	
	public void stop ()
	{
		if (!isStarted)
		{
			System.out.println("Air Conditioner is already stopped, we are doing nothing");
		}
		else
		{
			isStarted = false;
			temperature = Temperature.LOW;
		}
	}
}
