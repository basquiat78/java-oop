package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

/**
 * 
 * �ѱ��
 * created by basquiat
 *
 */
public class FirearmStrategy extends Weapon implements WeaponStrategy {

	public FirearmStrategy(String weaponName) {
		super(weaponName);
	}

	@Override
	public void wear() {
		System.out.println("�ѱ���� �����մϴ�.");
	}

	@Override
	public void fight() {
		System.out.println("���� ���ϴ�.");
	}
	
}
