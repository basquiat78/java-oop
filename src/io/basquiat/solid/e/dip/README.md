# Dependency Inversion Principle (DIP): 의존 역전 원칙

<h3>
고수준 모듈은 저수준 모듈의 구현에 의존해서는 안된다.    
</h3>
<h3>
저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야 한다.
</h3>

역시 말이 어렵다. 하지만 우리는 맨 처음 OCP를 하면서 경험했던 strategy pattern을 상기해야하는 상황이 온것이다.

이것은 이미 OCP 예제에서 적용된 부분이지만 다른 예제를 통해서 다시 한번 상기시켜 보자.

## 시나리오 1

역시 게임을 예로 드는게 젤 좋다.     
한때 서든 어택을 엄청 해왔으니 해당 게임의 액션을 보고 한번 시나리오를 만들어보고자 한다.

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
		System.out.println("총을 들고 싸움을 합니다.");
	}
	
}


```

거두절미하고 군인이 되면 누구나 하나씩 총을 지급받게 된다. 따라서 전쟁이 터졌다고 하면 일반적으로 총을 들고 싸움을 하게 된다 이말이다.

자...뭐 겜 자체에는 점프도 하고 앉기도 하고 걷기도 하고 뛰기도 하고 다양한 액션이 벌어지지만 일단은 총을 들고 싸운다는 행위 자체에만 한번 집중을 해 보자.

우리는 군인을 만들었으니 전쟁을 하면 되는 것이다.

## 시나리오 2

누군가가 이런 질문을 한다.

어? 만일 어떤 이유로 총이 아닌 육탄전을 해야 하는 상황이 오게 되면 어떻게 해야 하나요?? 

개발자는 잠깐 생각을 하더니 다음과 같이 코딩을 하게 된다.

"그거야 쉽지. 금방 해 줄께~"

일단 Weapon.java를 만들고 시작할 것이다.


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
		System.out.println("총을 집어 듭니다.");
		System.out.println("총을 쏩니다.");
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
		System.out.println("칼을 집어 듭니다.");
		System.out.println("칼을 휘두릅니다.");
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

개발자는 요구사항을 요청한 담당자에게 의기양양하게 빠른 방식으로 수정했다고 말을 한다.

그러자 담당자는 또 다른 요구 사항을 줄구장창 요구하기 시작했다.

"저기 개발자님, 수류탄도 있고, 총 종류도 여러 종류가 있고 그에 따라 특징들이 다 다른데요. 일단은 수류탄을 던질 수 있게 수정해 주세요. 그리고 그거 끝나면 바주카포, 머신건, 산탄총도 부탁드려요. 더 있지만 일단 여기까지만 요청하고 다른 요청도 상당히 많은데 다음에 이야기할꼐요. 지금 딱히 생각나는 무기가 없으니"

개발자는 고민하기 시작한다.

왜냐하면 불보듯 뻔하기 때문이다. 일단 각 종 무기류가 추가되는 것은 문제가 없지만 그에 따라서 Soldier클래스 내부가 지저분해질 것은 뻔하기 때문이다. 일단 딱 보기에도 LSP를 위반하고 있다.

물론 OCP도 마찬가지이다.

이제 위에서 DIP를 소개하면서 맨 처음 했던 고수준/저수준 모듈에 대한 이야기를 할 때가 온것이다.

지금 이 상황을 이 두가지 모듈에 대해서 이야기 하자면 다음과 같이 이야기 할 수 있다.

1. 고수준 모듈    
 군인이 어떤 무기를 차고 있고 그 무기에 맞는 싸움 전략을 표현한다.    
 
2. 저수준 모듈    
 2.1 어떤 무기를 차고 있는지 알아 낸다.    
 2.2 해당 무기의 싸움 전략으로 표현한다.    
 
그러면 왜 위 코드가 DIP를 위배하고 있는것이냐고 물어볼 것이다.

일단 군인이 싸우는 행위를 지금 Gun, Knife의 구현체에 의존하고 있다. 즉 저수준 모듈인 Gun, Knife에 의존하게 되고 추가가 될 수록 그 의존도는 높아지며 결국에는 저수준 모듈에 결합도가 강력해 지는 상황이 발생하게 되면 저수준 모듈에 따른 로직 변경은 불보듯 뻔하게 당연할 것이기 때문이다. 아마도 Soldier클래스 내부는 무수히 불어날 무기들의 인스턴스를 갖게 될것이고 그 무기수만큼 instanceof 연산자를 써야한다는 것이다. 생각만 해도...

개발자는 고민하기 시작하면서 다음과 같이 작업을 시작하기 시작했다.


## 시나리오 3

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

일단은 Weapon을 인터페이스가 아닌 클래스로 작성을 하기 시작했다.
이것은 물론 무기가 가지는 공통된 속성들을 담기 위한 객체로 탈바꿈 시키기 위한 조치이다.

그리고 무기의 가지고 있는 특징들, 예를 들면 총기류, 폭발과 관련된 폭발물, 설치하는 스타일을 설치물로 구분하기 위한 전략을 사용하기로 맘을 바꾼다. 무기의 특징들이 세분화되고 다양화 될수록 빠르게 대처하기 위함도 있다.

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
무기를 착용하고 싸우는 행위를 정의한 인터페이스를 하나 설정했다.

이제부터 개발자는 Weapon을 확장하고 WeaponStrategy를 구현해서 각 무기들의 특징에 따른 인터페이스를 만들기 시작했다.

FirearmStrategy.java

```
package io.basquiat.solid.e.dip.strategy;

import io.basquiat.solid.e.dip.model.Weapon;

/**
 * 
 * 총기류
 * created by basquiat
 *
 */
public class FirearmStrategy extends Weapon implements WeaponStrategy {

	public FirearmStrategy(String weaponName) {
		super(weaponName);
	}

	@Override
	public void wear() {
		System.out.println("총기류를 장착합니다.");
	}

	@Override
	public void fight() {
		System.out.println("총을 쏩니다.");
	}
	
}

```
총기류관련 클래스를 작성하고 폭발물관련 클래스인 ExplosivesStrategy도 작성한다.

물론 투척류, 칼, 도검같은 근접류 무기도 있겠지만 일단 이 두가지로만 예를 들어본다.

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
		System.out.println("폭발류를 장착합니다.");
	}

	@Override
	public void fight() {
		System.out.println("폭발물을 투척합니다.");
	}

}

```

수류탄을 구현한다.

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
		super("수류탄");
	}
	
}

```

물론 총도 구현해 보자

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
		super("총");
	}
	
}

```

이제는 무기의 확장에도 Soldier내부는 단지 외부에서 주입된 무기의 종류에 따라 싸움 전략을 교체할 수 있게 코드를 간결하게 작성하게 될 수 있었다.

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

SOLID의 마지막인 DIP를 정리하면서 결국 SOLID는 따로 떼놓고 이야기하기 힘들다는 것을 느낀다.

과연 나는 이 모든 것을 아우룰 수 있는 개발자가 될 수 있을까 하는 도전을 다시금 받는다.