package com.nespresso.ecommerce.mosaic.storefront.security.auth;

import java.util.Calendar;

public class Climatiseur {

	protected String city;
    protected boolean startStatus;
    protected double temperature;
    protected Manufacturer manufacturer;

    public Climatiseur(String city){
        this.city = city;
    }

    /**
     * Start the Climatiseur
     */
    public void start(){
		double temperature = 0;
		switch (this.city){
			case "RABAT":
				temperature = 15;
			case "CASABLANCA":
				temperature = 12;
			case "AGADIR":
				temperature = 25;
		}
        if (startStatus != true){
            this.startStatus = true;
            this.temperature = temperature;
        }else{
            System.out.println("Climatiseur is already started, we are doing nothing");
        }
    }


    /**
     * Stop the Climatiseur
     */
    public void stop(){
        if (startStatus != true){
            System.out.println("Climatiseur is already stopped, we are doing nothing");
        }else{
            this.startStatus = false;
            this.temperature = 0;
        }
    }

    public void add(double i){
        if (startStatus == true) {
            // If we are between OCTOBER and MARCH, we allow to add temperature
            if (Calendar.getInstance().get(2) > 9 && Calendar.getInstance().get(2) < 3) {
                this.temperature += i;
            }else{ // if we are in warm season, do not allow to add temperature
                System.out.println("We are in warm season, you cannot add more temperature");
            }
        }else{ // if climatiseur is stopped, we do nothing
            System.out.println("Climatiseur is not started, please start it and try again");
        }
    }

    public void remove(double i){
        if (startStatus == true) {
            // If we are between APRIL and SEPTEMBER, we allow to decrease temperature
            if (Calendar.getInstance().get(2) > 4 && Calendar.getInstance().get(2) < 9) {
                this.temperature -= i;
            }else{ // if we are in warm season, do not allow to add temperature
                System.out.println("We are in warm season, you cannot add more temperature");
            }
        }else{ // if climatiseur is stopped, we do nothing
            System.out.println("Climatiseur is not started, please start it and try again");
        }
    }

	/**
     * Display the temperature
     */
    public void displayTemperature(){
        if (startStatus != true){
            System.out.println("Climatiseur is stopped, temperature is unkown");
        }else{
            System.out.println("Temperature is " + this.temperature);
        }
    }
	
    public double getTemperature(){
        return temperature;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }

    static class Manufacturer{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
	
}
