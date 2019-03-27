package io.basquiat.solid.e.dip.model;

import io.basquiat.solid.e.dip.strategy.WeaponStrategy;

/**
 * 
 * created by basquiat
 *
 */
public class Soldier {

	private WeaponStrategy weaponStrategy;
	
	public void setWeapon(WeaponStrategy weaponStrategy) {
		this.weaponStrategy = weaponStrategy;
	}
	
	public void fight() {
		weaponStrategy.wear();
		weaponStrategy.fight();
	}
	
}
