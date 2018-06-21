package src.kroutled.weather;

public class Coordinates {
	private int longitude = 0;
	private int latitude = 0;
	private int height = 0;

	public Coordinates (int longitude, int latitude, int height)
	{
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

}
