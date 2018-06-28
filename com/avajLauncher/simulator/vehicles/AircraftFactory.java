package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;

public class AircraftFactory {

	public static Flyable newAircraft (String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch(type){
			case "Baloon":
				return new Baloon(name, coordinates);
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "JetPlane":
				return new JetPlane(name, coordinates);
			default:
				return null;
		}
	}
}
