package vehicles;

import java.util.List;

public abstract class Tower {
	
	private List<Flyable> observers = new List<Flyable>();


	public void register(Flyable flyable)
	{
		if (observers.contains(flyable) == false)
		{
			observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable)
	{
		if (observers.contains(flyable))
		{
			observsers.remove(flyable);
		}
	}

	protected void conditionsChanged()
	{
		int i = 0;

		while (observers[i])
		{
			observers[i].updateConditions();
		}
	}
}
