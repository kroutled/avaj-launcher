package com.avajLauncher.weather;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private static String[] weather;

	private  WeatherProvider()
	{
		weatherProvider = new WeatherProvider();
		weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
	}

	public static WeatherProvider getProvider()
	{
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{

		int rand = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return weather[rand % 4];	
	}
}
