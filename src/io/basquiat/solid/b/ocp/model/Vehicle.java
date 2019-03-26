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
	
}
