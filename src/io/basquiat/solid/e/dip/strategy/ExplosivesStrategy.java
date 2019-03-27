package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

/**
 * ����ź��
 * created by basquiat
 *
 */
public class ExplosivesStrategy extends Weapon implements WeaponStrategy {

	public ExplosivesStrategy(String weaponName) {
		super(weaponName);
	}

	@Override
	public void wear() {
		System.out.println("���߷��� �����մϴ�.");
	}

	@Override
	public void fight() {
		System.out.println("���߹��� ��ô�մϴ�.");
	}

}
