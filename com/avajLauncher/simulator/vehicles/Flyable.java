package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.simulator.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
