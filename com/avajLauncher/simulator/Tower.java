package com.avajLauncher.simulator;

import java.util.List;
import java.util.ArrayList;
import com.avajLauncher.simulator.vehicles.Flyable;

public class Tower {
	
	private List<Flyable> observers = new ArrayList<Flyable>();


	public void register(Flyable flyable)
	{
		//if (observers.contains(flyable) == false)
		//{
			observers.add(flyable);
		//}
	}

	public void unregister(Flyable flyable)
	{
		if (observers.contains(flyable))
		{
			observers.remove(flyable);
		}
	}

	protected void conditionsChanged()
	{
		for (int i = 0; i  < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}
