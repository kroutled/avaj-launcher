package vehicles;

import com.avajLauncher.weather;

public abstract class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected long Aircraft(string name, Coordinates coordinates)
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
