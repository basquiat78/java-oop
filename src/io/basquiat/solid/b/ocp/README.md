# Open-Closed Principle (OCP): 개방-폐쇄 원칙

<h3>
클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀 있어야 한다
</h3>

말이 어렵다.    
하지만 이 OCP라는 것은 일종의 디자인 패턴을 고려해 볼 때 Strategy Pattern을 적용해 볼 수 있는 아주 좋은 예제이다.

그러면 Strategy Pattern이 무엇일까?    

[About Strategy Pattern](https://ko.wikipedia.org/wiki/%EC%A0%84%EB%9E%B5_%ED%8C%A8%ED%84%B4)


## 시나리오 1

Vehicle, 즉 탈것에 대한 어떤 것을 구현해 보자. 예를 들면 게임, 특히 내가 정말 미쳐서 했던 와우에는 이 탈것이라는 것이 존재한다.

당시 처음 40레벨이 되면 말을 탈 수 있게 된다. 하지만 속도가 60프로 정도 나오는 말이다.

그냥 생각나는대로 작성을 해보자.

일단 캐릭터가 있을것이다.


GameCharacter.java

```
package io.basquiat.solid.b.ocp.model;

/**
 * 
 * created by basquiat
 *
 */
public class GameCharacter {

	private final Horse horse = new Horse();
	
	public void ride() {
		horse.ride();
	}
	
	public void move() {
		horse.move();
	}
	
}


```


Horse.java

```
package io.basquiat.solid.b.ocp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Horse {
	
	/**
	 * 말을 타는 행위
	 */
	public void ride() {
		System.out.println("말을 탑니다.");
	}
	
	/**
	 * 이동하는 행위
	 */
	public void move() {
		System.out.println("말을 타고 이동합니다.");
	}

}

```

Main.java

```
package io.basquiat.solid.b.ocp;

import io.basquiat.solid.b.ocp.model.GameCharacter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameCharacter gameCharacter = new GameCharacter();
		gameCharacter.ride();
		gameCharacter.move();
		
	}

}
```

자 우리는 게임 캐릭터를 생성하고 탈것에 올라서 움직이는 액션을 취했다.
그랬더니 너무나 말을 잘 타고 달리기 시작한다.

## 시나리오 2
그런데 문제가 있다. 레벨이 오르고 나니 탈것중에 날것도 있다.

그래서 코드를 수정해야하는 상황이 발생했다. 어떻게 수정할 것인가?

일단 Horse라는 클래스가 좀 문제가 있다. 왜냐하면 탈것 종류가 여러개가 될 것이라는 것을 염두해 둔다면 공통 관심사는 분리하고 그것을 extends해서 구현하는 방식을 취하기로 결정을 했다.

그랬더니 다음과 같이 수정을 하게 된다.

타는 행위와 움직이는 행위는 공통되는 부분이니 Vehicle이라는 객체를 생성한다.

Vehicle.java

```
package io.basquiat.solid.b.ocp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Vehicle {

	public void ride() {
		System.out.println("탈것에 탑니다.");
	}
	
	public void move() {
		System.out.println("탈것을 타고 이동합니다.");
	}
}

```

Horse.java

```
package io.basquiat.solid.b.ocp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Horse extends Vehicle {
	
	/**
	 * 말을 타는 행위
	 */
	@Override
	public void ride() {
		System.out.println("말을 탑니다.");
	}
	
	/**
	 * 이동하는 행위
	 */
	@Override
	public void move() {
		System.out.println("말을 타고 이동합니다.");
	}

}

```



BigBird.java

```
package io.basquiat.solid.b.ocp.model;

public class BigBird extends Vehicle {
	
	/**
	 * 말을 타는 행위
	 */
	@Override
	public void ride() {
		System.out.println("새에 올라 탑니다.");
	}
	
	/**
	 * 이동하는 행위
	 */
	@Override
	public void move() {
		System.out.println("새에 올라 타고 이동합니다.");
	}

}

```

GameCharacter.java

```
package io.basquiat.solid.b.ocp.model;

/**
 * 
 * created by basquiat
 *
 */
public class GameCharacter {

	private Horse horse;
	
	private BigBird bigBird;
	
	private Vehicle vehicle;
	
	public GameCharacter() {
		this.horse = new Horse();
		this.bigBird = new BigBird();
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void ride() {
		if(vehicle instanceof Horse) {
			horse.ride();
		} else {
			bigBird.ride();
		}
	}
	
	public void move() {
		if(vehicle instanceof Horse) {
			horse.move();
		} else {
			bigBird.move();
		}
	}
	
}

```

Vehicle을 extends해서 부모의 메소드를 재정의하고 탈것을 지정할 수 있게 해놨다.

그리고 GameCharacter에서는 탈것의 객체를 파라미터로 넘겨받아 어떤 것을 타고 달릴지를 결정하게 만들었다.

이 코드는 아무 문제 없이 돌아간다. 그리고 웃는다. 별거 아니네하고...

## 시나리오 3

또 다른 요구사항이 들어왔다. 바로 바다에서 탈수 있는 탈것을 만들어야 하는 요구사항을 받은 것이다.

그러면 또 개발자는 BigFish라는 객체를 만들고 위와 똑같은 행위를 할 것이다. 하지만 뭔가 GameCharacter내부가 지저분해지기 시작하고 수많은 if~else 구분이 이런 요청에 따라서 늘어날 것이라는 것을 고민하기 시작한다.

지금 위에 예저는 두 개의 법칙을 위반하고 있다.

1. Open-Closed Principle (OCP): 개방-폐쇄 원칙
2. Liskov Substitution Principle (LSP): 리스코프 치환 원칙

2번째 리스코프 치환 원칙은 OCP와 깊은 연관이 있기 때문에 따로 얘기하기 힘들다.
실제로 상위 객체, 즉 부모 객체에 정의된 메소드를 서브 클래스에서도 그대로 쓸 수 있어야 한다.
근데 위 코드는 부모의 메소드를 재정의해서 사용하고 있다. 이것은 다형성에 기반한 OCP에 많은 제약을 준다.

따라서 이 코드는 앞으로 들어올 요구에 반복되는 코드 수정이 가해질 것이고 복잡해지면 차후 유지보수와 다른 요구사항에 빠르게 대처할 수 없게 된다.

그렇다면 Strategy Pattern을 어떻게 적용해 볼 것인가에 대해 고민을 해야할 때다.


일단 곰곰히 생각해 보자...결국 우리는 interface에 대고 개발을 해야 할 시점이 온 것이다.

언제나 공통된 관심사를 분리하는 것부터 시작하자.

첫 번째로는 Vehicle이라는 관점에서 하나의 interface를 생성해 보자.

VehicleStrategy.java

```
package io.basquiat.solid.b.ocp.strategy;

/**
 * 
 * created by basquiat
 *
 */
public interface VehicleStrategy {

	public void ride();
	
	public void move();
	
}


```

심플하다. 그렇다면 지금 저 위에서 언급했던 요구 사항을 잘 살펴보면 육해공을 이야기 할 수 있겠다.

SkyVehicleStrategy.java

```
package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class SkyVehicleStrategy extends Vehicle implements VehicleStrategy {

	public SkyVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("날것에 탑승합니다.");
		
	}

	@Override
	public void move() {
		System.out.println("하늘을 따라 이동합니다.");
	}
	
}

```

EarthVehicleStrategy.java

```
package io.basquiat.solid.b.ocp.strategy;

import io.basquiat.solid.b.ocp.model.Vehicle;

public class EarthVehicleStrategy extends Vehicle implements VehicleStrategy {

	public EarthVehicleStrategy(String vehicleName) {
		super(vehicleName);
	}
	
	@Override
	public void ride() {
		System.out.println("육상 탈것에 탑승합니다.");
		
	}

	@Override
	public void move() {
		System.out.println("육지를 이동합니다.");
	}
	
}


```

Vehicle.java

```
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
	
	public void ride() {
		System.out.println("탈것에 탑니다.");
	}
	
	public void move() {
		System.out.println("탈것을 타고 이동합니다.");
	}
}
```

최종적으로 GameCharacter는 다음과 같이 바뀌게 될것이다.

GameCharacter.java

```
package io.basquiat.solid.b.ocp.model;

import io.basquiat.solid.b.ocp.strategy.VehicleStrategy;

/**
 * 
 * created by basquiat
 *
 */
public class GameCharacter {

	private VehicleStrategy vehicleStrategy;
	
	public void setVehicle(VehicleStrategy vehicleStrategy) {
		this.vehicleStrategy = vehicleStrategy;
	}
	
	public void ride() {
		vehicleStrategy.ride();
	}
	
	public void move() {
		vehicleStrategy.move();
	}
	
}
```

Main.java

```
package io.basquiat.solid.b.ocp;

import io.basquiat.solid.b.ocp.model.BigBird;
import io.basquiat.solid.b.ocp.model.GameCharacter;
import io.basquiat.solid.b.ocp.model.Horse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameCharacter gameCharacter = new GameCharacter();
		gameCharacter.setVehicle(new Horse());
		gameCharacter.ride();
		gameCharacter.move();
		
		gameCharacter.setVehicle(new BigBird());
		gameCharacter.ride();
		gameCharacter.move();
	}

}

```

자...그러면 위와 같은 상황에서 바다에서 탈 수 있는 것을 만들게 된다면 우리는 GameCharacter의 로직을 바꾸지 않고 단지 VehicleStrategy와 예를 들면 SeaVehicleStrategy 클래스를 생성해서 단지 GameCharacter에 setVehicle를 하는 것만으로 요청 사항을 추가 할 수 있게 되었다.

또한 기존의 탈것외에도 다양한 탈것들을 추가하는데 있어서 역시 유연함을 얻게 된다.

앞으로 어떤 요청이 들어오게 되면 단지 추가하는 것만으로도 기존 로직을 변경하지 않고 유연하게 확장할 수 있게 되었다.