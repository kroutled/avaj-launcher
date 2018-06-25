package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Helicopter (String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates; 
	}

	public void updateConditions()
	{
		String weather = weatherTower.getWeather(this.coordinates);

		switch(weather)
		{
			case "RAIN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				break;
			case "FOG":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "SUN":
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
		}

		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
			this.weatherTower.unregister(this);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
