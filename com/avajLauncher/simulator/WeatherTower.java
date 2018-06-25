package simulator;

public class WeatherTower {

	public string	getWeather(Coordinates coordinates)
	{
		WeatherProvider weatherProvider= new WeatherProvider();
		
		return weatherProvider.getCurrentWeather(coordinates);
	}

	void	changeWeather()
	{
		this.condiotionsChanged(); 
	}
}
