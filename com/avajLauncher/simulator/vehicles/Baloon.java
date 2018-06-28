package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;
import com.avajLauncher.simulator.Simulator;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Baloon (String name, Coordinates coordinates)
	{
		super(name, coordinates);
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
				Simulator.writer.printf("Baloon#%s(%d): Damn you rain! You messed up my baloon\n", this.name, this.id);
				break;
			case "FOG":
				this.coordinates.setHeight(this.coordinates.getHeight() - 3);
				Simulator.writer.printf("Baloon#%s(%d): Cant see anything with this damn fog!\n", this.name, this.id);
				break;
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				Simulator.writer.printf("Baloon#%s(%d): I can see everything with this sun, how awesome!\n", this.name, this.id);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				Simulator.writer.printf("Baloon#%s(%d): It's snowing. We're gonna crash.\n", this.name, this.id);
				break;
		}
		
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
		{
			Simulator.writer.printf("Baloon#%s(%d) has landed at %d, %d, %d \n" , this.name, this.id, this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());
			Simulator.writer.printf("Baloon#%s(%d) has deregistered from the weather tower\n", this.name, this.id);
			this.weatherTower.unregister(this);
		}
	}

	public void	registerTower(WeatherTower weatherTower)
	{	
		Simulator.writer.printf("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
