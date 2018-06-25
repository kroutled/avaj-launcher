package com.avajLauncher.weather;

public class Coordinates {
	private int longitude = 0;
	private int latitude = 0;
	private int height = 0;

	Coordinates (int longitude, int latitude, int height)
	{
		if (height < 0)
			height = 0;
		else if (height > 100)
			height = 100;

		if (latitude < 0)
			latitude = 0;

		if (longitude < 0)
			longitude = 0;

		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getLatitude()
	{
		return this.latitude;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setLongitude(int longitude)
	{
		this.longitude = longitude;
	}

	public void setLatitude(int latitude)
	{
		this.latitude = latitude;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

}
