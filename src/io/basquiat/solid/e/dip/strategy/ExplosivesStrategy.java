package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

/**
 * ¼ö·ùÅº·ù
 * created by basquiat
 *
 */
public class ExplosivesStrategy extends Weapon implements WeaponStrategy {

	public ExplosivesStrategy(String weaponName) {
		super(weaponName);
	}

	@Override
	public void wear() {
		System.out.println("Æø¹ß·ù¸¦ ÀåÂøÇÕ´Ï´Ù.");
	}

	@Override
	public void fight() {
		System.out.println("Æø¹ß¹°À» ÅõÃ´ÇÕ´Ï´Ù.");
	}

}
