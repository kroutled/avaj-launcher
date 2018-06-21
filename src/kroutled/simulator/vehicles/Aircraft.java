package avaj.src.kroutled.simulator.vehicles;

import avaj.src.kroutled.weather;

public class Aircraft {

	protected long id;
	protected string name;
	protected Coordinates coordinates;

	private long idCounter = 0;

	protected long Aircraft(string name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private	long nextId()
	{
		return id++;
	}
}
