package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;

public class Aircraft {

	protected long id = 0;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected void  Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private	long nextId()
	{
		idCounter++;
		return idCounter;
	}
}
