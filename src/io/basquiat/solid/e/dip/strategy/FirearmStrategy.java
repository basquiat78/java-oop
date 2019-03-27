package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

/**
 * 
 * ÃÑ±â·ù
 * created by basquiat
 *
 */
public class FirearmStrategy extends Weapon implements WeaponStrategy {

	public FirearmStrategy(String weaponName) {
		super(weaponName);
	}

	@Override
	public void wear() {
		System.out.println("ÃÑ±â·ù¸¦ ÀåÂøÇÕ´Ï´Ù.");
	}

	@Override
	public void fight() {
		System.out.println("ÃÑÀ» ½õ´Ï´Ù.");
	}
	
}
