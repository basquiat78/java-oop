# Dependency Inversion Principle (DIP): ���� ���� ��Ģ

<h3>
����� ����� ������ ����� ������ �����ؼ��� �ȵȴ�.    
</h3>
<h3>
������ ����� ����� ��⿡�� ������ �߻� Ÿ�Կ� �����ؾ� �Ѵ�.
</h3>

���� ���� ��ƴ�. ������ �츮�� �� ó�� OCP�� �ϸ鼭 �����ߴ� strategy pattern�� ����ؾ��ϴ� ��Ȳ�� �°��̴�.

�̰��� �̹� OCP �������� ����� �κ������� �ٸ� ������ ���ؼ� �ٽ� �ѹ� ������ ����.

## �ó����� 1

���� ������ ���� ��°� �� ����.     
�Ѷ� ���� ������ ��û �ؿ����� �ش� ������ �׼��� ���� �ѹ� �ó������� �������� �Ѵ�.

Soldier.java

```
package io.basquiat.solid.e.dip.model;

/**
 * 
 * created by basquiat
 *
 */
public class Soldier {

	public void fight() {
		System.out.println("���� ��� �ο��� �մϴ�.");
	}
	
}


```

�ŵ������ϰ� ������ �Ǹ� ������ �ϳ��� ���� ���޹ް� �ȴ�. ���� ������ �����ٰ� �ϸ� �Ϲ������� ���� ��� �ο��� �ϰ� �ȴ� �̸��̴�.

��...�� �� ��ü���� ������ �ϰ� �ɱ⵵ �ϰ� �ȱ⵵ �ϰ� �ٱ⵵ �ϰ� �پ��� �׼��� ���������� �ϴ��� ���� ��� �ο�ٴ� ���� ��ü���� �ѹ� ������ �� ����.

�츮�� ������ ��������� ������ �ϸ� �Ǵ� ���̴�.

## �ó����� 2

�������� �̷� ������ �Ѵ�.

��? ���� � ������ ���� �ƴ� ��ź���� �ؾ� �ϴ� ��Ȳ�� ���� �Ǹ� ��� �ؾ� �ϳ���?? 

�����ڴ� ��� ������ �ϴ��� ������ ���� �ڵ��� �ϰ� �ȴ�.

"�װž� ����. �ݹ� �� �ٲ�~"

�ϴ� Weapon.java�� ����� ������ ���̴�.


Weapon.java

```
package io.basquiat.solid.e.dip.model;

/**
 * 
 * created by basquiat
 *
 */
public interface Weapon {

	public void weaponAndFight();
	
}


```

Gun.java

```
package io.basquiat.solid.e.dip.model;

/**
 * 
 * created by basquiat
 *
 */
public class Gun implements Weapon {

	public void weaponAndFight() {
		System.out.println("���� ���� ��ϴ�.");
		System.out.println("���� ���ϴ�.");
	}
	
}

```

Knife.java

```
package io.basquiat.solid.e.dip.model;

/**
 * 
 * created by basquiat
 *
 */
public class Knife implements Weapon {

	public void weaponAndFight() {
		System.out.println("Į�� ���� ��ϴ�.");
		System.out.println("Į�� �ֵθ��ϴ�.");
	}
	
}

```

Soldier.java

```
package io.basquiat.solid.e.dip.model;

/**
 * 
 * created by basquiat
 *
 */
public class Soldier {

	private Weapon gun;
	
	private Weapon knife;
	
	public Soldier() {
		this.gun = new Gun();
		this.knife = new Knife();
	}
	
	public void fight(Weapon weapon) {
		if(weapon instanceof Gun) {
			gun.weaponAndFight();
		} else if(weapon instanceof Knife) {
			knife.weaponAndFight();
		}
	}
	
}

```

�����ڴ� �䱸������ ��û�� ����ڿ��� �Ǳ����ϰ� ���� ������� �����ߴٰ� ���� �Ѵ�.

�׷��� ����ڴ� �� �ٸ� �䱸 ������ �ٱ���â �䱸�ϱ� �����ߴ�.

"���� �����ڴ�, ����ź�� �ְ�, �� ������ ���� ������ �ְ� �׿� ���� Ư¡���� �� �ٸ�����. �ϴ��� ����ź�� ���� �� �ְ� ������ �ּ���. �׸��� �װ� ������ ����ī��, �ӽŰ�, ��ź�ѵ� ��Ź�����. �� ������ �ϴ� ��������� ��û�ϰ� �ٸ� ��û�� ����� ������ ������ �̾߱��Ҳ���. ���� ���� �������� ���Ⱑ ������"

�����ڴ� ����ϱ� �����Ѵ�.

�ֳ��ϸ� �Һ��� ���ϱ� �����̴�. �ϴ� �� �� ������� �߰��Ǵ� ���� ������ ������ �׿� ���� SoldierŬ���� ���ΰ� ���������� ���� ���ϱ� �����̴�. �ϴ� �� ���⿡�� LSP�� �����ϰ� �ִ�.

���� OCP�� ���������̴�.

���� ������ DIP�� �Ұ��ϸ鼭 �� ó�� �ߴ� �����/������ ��⿡ ���� �̾߱⸦ �� ���� �°��̴�.

���� �� ��Ȳ�� �� �ΰ��� ��⿡ ���ؼ� �̾߱� ���ڸ� ������ ���� �̾߱� �� �� �ִ�.

1. ����� ���    
 ������ � ���⸦ ���� �ְ� �� ���⿡ �´� �ο� ������ ǥ���Ѵ�.    
 
2. ������ ���    
 2.1 � ���⸦ ���� �ִ��� �˾� ����.    
 2.2 �ش� ������ �ο� �������� ǥ���Ѵ�.    
 
�׷��� �� �� �ڵ尡 DIP�� �����ϰ� �ִ°��̳İ� ��� ���̴�.

�ϴ� ������ �ο�� ������ ���� Gun, Knife�� ����ü�� �����ϰ� �ִ�. �� ������ ����� Gun, Knife�� �����ϰ� �ǰ� �߰��� �� ���� �� �������� �������� �ᱹ���� ������ ��⿡ ���յ��� ������ ���� ��Ȳ�� �߻��ϰ� �Ǹ� ������ ��⿡ ���� ���� ������ �Һ��� ���ϰ� �翬�� ���̱� �����̴�. �Ƹ��� SoldierŬ���� ���δ� ������ �Ҿ ������� �ν��Ͻ��� ���� �ɰ��̰� �� �������ŭ instanceof �����ڸ� ����Ѵٴ� ���̴�. ������ �ص�...

�����ڴ� ����ϱ� �����ϸ鼭 ������ ���� �۾��� �����ϱ� �����ߴ�.


## �ó����� 3

Weapon.java

```
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

```

�ϴ��� Weapon�� �������̽��� �ƴ� Ŭ������ �ۼ��� �ϱ� �����ߴ�.
�̰��� ���� ���Ⱑ ������ ����� �Ӽ����� ��� ���� ��ü�� Ż�ٲ� ��Ű�� ���� ��ġ�̴�.

�׸��� ������ ������ �ִ� Ư¡��, ���� ��� �ѱ��, ���߰� ���õ� ���߹�, ��ġ�ϴ� ��Ÿ���� ��ġ���� �����ϱ� ���� ������ ����ϱ�� ���� �ٲ۴�. ������ Ư¡���� ����ȭ�ǰ� �پ�ȭ �ɼ��� ������ ��ó�ϱ� ���Ե� �ִ�.

WeaponStrategy.java

```
package io.basquiat.solid.e.dip.strategy;

/**
 * 
 * created by basquiat
 *
 */
public interface WeaponStrategy {

	public void wear();
	
	public void fight();
	
}


```
���⸦ �����ϰ� �ο�� ������ ������ �������̽��� �ϳ� �����ߴ�.

�������� �����ڴ� Weapon�� Ȯ���ϰ� WeaponStrategy�� �����ؼ� �� ������� Ư¡�� ���� �������̽��� ����� �����ߴ�.

FirearmStrategy.java

```
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

```
�ѱ������ Ŭ������ �ۼ��ϰ� ���߹����� Ŭ������ ExplosivesStrategy�� �ۼ��Ѵ�.

���� ��ô��, Į, ���˰��� ������ ���⵵ �ְ����� �ϴ� �� �ΰ����θ� ���� ����.

ExplosivesStrategy.java

```
package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

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

```

����ź�� �����Ѵ�.

HandGrenade.java

```
package io.basquiat.solid.e.dip.model;

import io.basquiat.solid.e.dip.strategy.ExplosivesStrategy;

/**
 * 
 * created by basquiat
 *
 */
public class HandGrenade extends ExplosivesStrategy {

	public HandGrenade() {
		super("����ź");
	}
	
}

```

���� �ѵ� ������ ����

Gun.java

```
package io.basquiat.solid.e.dip.model;

import io.basquiat.solid.e.dip.strategy.FirearmStrategy;

/**
 * 
 * created by basquiat
 *
 */
public class Gun extends FirearmStrategy {

	public Gun() {
		super("��");
	}
	
}

```

������ ������ Ȯ�忡�� Soldier���δ� ���� �ܺο��� ���Ե� ������ ������ ���� �ο� ������ ��ü�� �� �ְ� �ڵ带 �����ϰ� �ۼ��ϰ� �� �� �־���.

Soldier.java

```
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


```

Main.java

```
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


```

# At A Glance

SOLID�� �������� DIP�� �����ϸ鼭 �ᱹ SOLID�� ���� ������ �̾߱��ϱ� ����ٴ� ���� ������.

���� ���� �� ��� ���� �ƿ�� �� �ִ� �����ڰ� �� �� ������ �ϴ� ������ �ٽñ� �޴´�.