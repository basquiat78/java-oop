package io.basquiat.solid.e.dip;

import io.basquiat.solid.e.dip.model.Gun;
import io.basquiat.solid.e.dip.model.HandGrenade;
import io.basquiat.solid.e.dip.model.Soldier;

/**
 * 
 * created by basquiat
 *
 */
public class Main {

	public static void main(String[] args) {

		Soldier soldier = new Soldier();
		soldier.setWeapon(new Gun());
		soldier.fight();

		soldier.setWeapon(new HandGrenade());
		soldier.fight();
		
		soldier.setWeapon(new Gun());
		soldier.fight();

	}

}
