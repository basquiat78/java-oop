package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class SkyVehicleStrategy extends Vehicle implements VehicleStrategy {

	public SkyVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("���Ϳ� ž���մϴ�.");
		
	}

	@Override
	public void move() {
		System.out.println("�ϴ��� ���� �̵��մϴ�.");
	}
	
}
