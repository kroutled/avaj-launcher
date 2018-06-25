package vehicles;

import com.avajLauncher.weather;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower = new WeatherTower();

	Baloon (string name, Coordinates coordinates)
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
				this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				break;
			case "FOG":
				this.coordinates.setHeight(this.Coordinates.getHeight() - 3);
				break;
			case "SUN":
				this.coordinates.setLongitude(this.Coordinates.getLogitude() + 2);
				this.coordinates.setHeight(this.Coordinates.getHeight() + 4);
				break;
			case "SNOW":
				this.coordinates.setHeight(this.Coordinates.getHeight() - 15);
				break;
		}
		
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);

		if (this.coordinates.getHeight() <= 0)
			this.weatherTower.unregister(this);
	}

	public void	registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
