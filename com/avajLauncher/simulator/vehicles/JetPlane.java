package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;
import com.avajLauncher.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	JetPlane(String name, Coordinates coordinates)
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
				System.out.printf("JetPlane#%s(%d): It's raining. Better watch out for lightings.\n", this.name, this.id);
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				break;
			case "FOG":
				System.out.printf("JetPlane#%s(%d): Good thing we're flying fast enough to dodge this fog.\n", this.name, this.id);
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
				break;
			case "SUN":
				System.out.printf("JetPlane#%s(%d): It's smooth flying on this sunny day\n", this.name, this.id);
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			case "SNOW":
				System.out.printf("JetPlane#%s(%d): OMG! Winter is coming!\n", this.name, this.id);
				this.coordinates.setHeight(this.coordinates.getHeight() - 7);
				break;
		}
		
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("JetPlane#%s(%d) has landed and deregistered from the weather tower\n", this.name, this.id);
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower)
	{	
		System.out.println("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);	
	}
}
