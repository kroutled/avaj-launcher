package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.weather.Coordinates;

public abstract class Aircraft {

	protected long id = 0;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private	long nextId()
	{
		++Aircraft.idCounter;
		return (Aircraft.idCounter);
	}
}
