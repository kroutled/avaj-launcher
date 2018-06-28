package com.avajLauncher.simulator.vehicles;

import java.io.*;
import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;
import com.avajLauncher.simulator.Simulator;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Helicopter (String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(this.coordinates);

		switch(weather)
		{
			case "RAIN":
				Simulator.writer.printf("Helicopter#%s(%d): I hope this rain doesnt rust up my blades...\n", this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				break;
			case "FOG":
				Simulator.writer.printf("Helicopter%s(%d): This fog is gonna cause a bumpy one, hang on boys!\n", this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "SUN":
				Simulator.writer.printf("Helicopter#%s(%d): This is hot.\n", this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			case "SNOW":
				Simulator.writer.printf("Helicopter#%s(%d): My rotor is going to freeze!\n", this.name, this.id);
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
		{
			Simulator.writer.printf("Helicopter#%s(%d) has landed at %d, %d, %d \n" , this.name, this.id, this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());	
			Simulator.writer.printf("Helicopter#%s(%d) has deregistered from the weather tower\n",this.name, this.id);
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		Simulator.writer.printf("Tower says: Helicopter#%s(%d) registered to weather tower\n", this.name, this.id);
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
