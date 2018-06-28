package com.avajLauncher.weather;

public class Coordinates {
	private int longitude = 0;
	private int latitude = 0;
	private int height = 0;

	public Coordinates (int longitude, int latitude, int height)
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
		if (this.longitude <= 0)
			this.longitude = 0;
		return this.longitude;
	}

	public int getLatitude()
	{
		if (this.latitude <= 0)
			this.latitude = 0;
		return this.latitude;
	}

	public int getHeight()
	{
		if (this.height <= 0)
			this.height = 0;
		if (this.height >= 100)
			this.height = 100;
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
