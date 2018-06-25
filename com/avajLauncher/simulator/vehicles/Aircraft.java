package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;

public abstract class Aircraft {

	protected long id;
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
		return idCounter++;
	}
}
