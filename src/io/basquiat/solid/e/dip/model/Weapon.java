package io.basquiat.solid.e.dip.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * created by basquiat
 *
 */
public class Weapon {

	public Weapon(String weaponName) {
		this.weaponName = weaponName;
	}
	
	@Setter
	@Getter
	private String weaponName;
	
}
