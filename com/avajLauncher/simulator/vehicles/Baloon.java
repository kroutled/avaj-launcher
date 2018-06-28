package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;
import com.avajLauncher.simulator.Simulator;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Baloon (String name, Coordinates coordinates)
	{
		//super(name, coordinates);
		this.name = name;
		this.coordinates = coordinates;
	}	

	public void updateConditions()
	{

		String weather = weatherTower.getWeather(this.coordinates);

		switch(weather)
		{
			case "RAIN":
				this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				System.out.println("Damn you rain! You messed up my baloon");
				break;
			case "FOG":
				this.coordinates.setHeight(this.coordinates.getHeight() - 3);
				System.out.println("Cant see anything with this damn fog!");
				break;
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				System.out.println("I can see everything with this sun, how awesome!");
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				System.out.println("It's snowing. We're gonna crash.");
				break;
		}
		
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("Baloon#%s(%d) has landed and deregistered from the weather tower\n", this.name, this.id);
			this.weatherTower.unregister(this);
		}
	}

	public void	registerTower(WeatherTower weatherTower)
	{	
		System.out.println("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
