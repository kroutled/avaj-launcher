package vehicles;

import com.avajLauncher.weather;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	JetPlane(string name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
	}

	public void updateConditions()
	{

		string weather = weatherTower.getWeather(this.coordinates);

		switch(weather)
		{
			case "RAIN":
				this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
				break;
			case "FOG":
				this.coordinates.setLatitude(this.Coordinates.getLatitude() + 1);
				break;
			case "SUN":
				this.coordinates.setLatitude(this.Coordinates.getLatitude() + 10);
				this.coordinates.setHeight(this.Coordinates.getHeight() + 2);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.Coordinates.getHeight() - 7);
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
