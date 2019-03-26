package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class SkyVehicleStrategy extends Vehicle implements VehicleStrategy {

	public SkyVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("날것에 탑승합니다.");
		
	}

	@Override
	public void move() {
		System.out.println("하늘을 따라 이동합니다.");
	}
	
}
