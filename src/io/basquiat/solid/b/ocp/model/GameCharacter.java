package io.basquiat.solid.b.ocp.model;

import io.basquiat.solid.b.ocp.strategy.VehicleStrategy;

/**
 * 
 * created by basquiat
 *
 */
public class GameCharacter {

	private VehicleStrategy vehicleStrategy;
	
	public void setVehicle(VehicleStrategy vehicleStrategy) {
		this.vehicleStrategy = vehicleStrategy;
	}
	
	public void ride() {
		vehicleStrategy.ride();
	}
	
	public void move() {
		vehicleStrategy.move();
	}
	
}
