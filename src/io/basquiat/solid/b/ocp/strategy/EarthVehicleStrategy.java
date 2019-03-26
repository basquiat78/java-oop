package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class EarthVehicleStrategy extends Vehicle implements VehicleStrategy {

	public EarthVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("À°»ó Å»°Í¿¡ Å¾½ÂÇÕ´Ï´Ù.");
		
	}

	@Override
	public void move() {
		System.out.println("À°Áö¸¦ ÀÌµ¿ÇÕ´Ï´Ù.");
	}
	
}
