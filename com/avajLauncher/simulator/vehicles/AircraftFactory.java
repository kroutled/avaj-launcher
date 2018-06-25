package vehicles;

public abstract class AircraftFactory {

	public Flyable newAircraft (String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		switch(type){
			case "Baloon":
				return new Baloon(name, coordinates);
				break;
			case "Helicopter":
				return new Helicopter(name, coordinates);
				break;
			case "JetPlane":
				return new JetPlane(name, coordinates);
				break;
		}
	}
}
