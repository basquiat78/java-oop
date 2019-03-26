package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class EarthVehicleStrategy extends Vehicle implements VehicleStrategy {

	public EarthVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("���� Ż�Ϳ� ž���մϴ�.");
		
	}

	@Override
	public void move() {
		System.out.println("������ �̵��մϴ�.");
	}
	
}
