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
		System.out.println("탈것에 탑니다.");
	}
	
	public void move() {
		System.out.println("탈것을 타고 이동합니다.");
	}
}
