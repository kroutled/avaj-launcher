package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Helicopter (String name, Coordinates coordinates)
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
				System.out.printf("Helicopter#%s(%d): This rain may make the rotors rust...\n", this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				break;
			case "FOG":
				System.out.printf("Helicopter#%s(%d): It just got hella foggy, might be a bumpy one boys!\n",this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "SUN":
				System.out.printf("Helicopter#%s(%d): This is hot.\n", this.name, this.id);
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			case "SNOW":
				System.out.printf("Helicopter#%s(%d): My rotor is going to freeze!\n", this.name, this.id);
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("Helicopter#%s(%d) has landed and deregistered from the weather tower\n", this.name, this.id);
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{
		System.out.println("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
