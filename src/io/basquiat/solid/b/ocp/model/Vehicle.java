package io.basquiat.solid.b.ocp.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * created by basquiat
 *
 */
public class Vehicle {

	public Vehicle(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	@Setter
	@Getter
	private String vehicleName;
	
	public void ride() {
		System.out.println("Ż�Ϳ� ž�ϴ�.");
	}
	
	public void move() {
		System.out.println("Ż���� Ÿ�� �̵��մϴ�.");
	}
}
