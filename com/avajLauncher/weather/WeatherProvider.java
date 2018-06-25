package com.avajLauncher.weather;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static string[] weather;

	private static WeatherProvider()
	{
		this.weatherProvider = new WeatherProvider();
		this.weather = new string[]{"RAIN", "FOG", "SUN", "SNOW"};
	}

	public WeatherProvider getProvider()
	{
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int rand = this.coordinates.getLongitude() + this.coordinates.getLatitude() + this.coordinates.getHeight();
		return weather[rand % 4];	
	}
}
