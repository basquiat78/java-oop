# Open-Closed Principle (OCP): ����-��� ��Ģ

<h3>
Ŭ������ ����� Ȯ�忡�� ���� �־�� �ϰ� ���濡�� ���� �־�� �Ѵ�
</h3>

���� ��ƴ�.    
������ �� OCP��� ���� ������ ������ ������ ����� �� �� Strategy Pattern�� ������ �� �� �ִ� ���� ���� �����̴�.

�׷��� Strategy Pattern�� �����ϱ�?    

[About Strategy Pattern](https://ko.wikipedia.org/wiki/%EC%A0%84%EB%9E%B5_%ED%8C%A8%ED%84%B4)


## �ó����� 1

Vehicle, �� Ż�Ϳ� ���� � ���� ������ ����. ���� ��� ����, Ư�� ���� ���� ���ļ� �ߴ� �Ϳ쿡�� �� Ż���̶�� ���� �����Ѵ�.

��� ó�� 40������ �Ǹ� ���� Ż �� �ְ� �ȴ�. ������ �ӵ��� 60���� ���� ������ ���̴�.

�׳� �������´�� �ۼ��� �غ���.

�ϴ� ĳ���Ͱ� �������̴�.


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
	 * ���� Ÿ�� ����
	 */
	public void ride() {
		System.out.println("���� ž�ϴ�.");
	}
	
	/**
	 * �̵��ϴ� ����
	 */
	public void move() {
		System.out.println("���� Ÿ�� �̵��մϴ�.");
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

�� �츮�� ���� ĳ���͸� �����ϰ� Ż�Ϳ� �ö� �����̴� �׼��� ���ߴ�.
�׷����� �ʹ��� ���� �� Ÿ�� �޸��� �����Ѵ�.

## �ó����� 2
�׷��� ������ �ִ�. ������ ������ ���� Ż���߿� ���͵� �ִ�.

�׷��� �ڵ带 �����ؾ��ϴ� ��Ȳ�� �߻��ߴ�. ��� ������ ���ΰ�?

�ϴ� Horse��� Ŭ������ �� ������ �ִ�. �ֳ��ϸ� Ż�� ������ �������� �� ���̶�� ���� ������ �дٸ� ���� ���ɻ�� �и��ϰ� �װ��� extends�ؼ� �����ϴ� ����� ���ϱ�� ������ �ߴ�.

�׷����� ������ ���� ������ �ϰ� �ȴ�.

Ÿ�� ������ �����̴� ������ ����Ǵ� �κ��̴� Vehicle�̶�� ��ü�� �����Ѵ�.

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
		System.out.println("Ż�Ϳ� ž�ϴ�.");
	}
	
	public void move() {
		System.out.println("Ż���� Ÿ�� �̵��մϴ�.");
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
	 * ���� Ÿ�� ����
	 */
	@Override
	public void ride() {
		System.out.println("���� ž�ϴ�.");
	}
	
	/**
	 * �̵��ϴ� ����
	 */
	@Override
	public void move() {
		System.out.println("���� Ÿ�� �̵��մϴ�.");
	}

}

```



BigBird.java

```
package io.basquiat.solid.b.ocp.model;

public class BigBird extends Vehicle {
	
	/**
	 * ���� Ÿ�� ����
	 */
	@Override
	public void ride() {
		System.out.println("���� �ö� ž�ϴ�.");
	}
	
	/**
	 * �̵��ϴ� ����
	 */
	@Override
	public void move() {
		System.out.println("���� �ö� Ÿ�� �̵��մϴ�.");
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

Vehicle�� extends�ؼ� �θ��� �޼ҵ带 �������ϰ� Ż���� ������ �� �ְ� �س���.

�׸��� GameCharacter������ Ż���� ��ü�� �Ķ���ͷ� �Ѱܹ޾� � ���� Ÿ�� �޸����� �����ϰ� �������.

�� �ڵ�� �ƹ� ���� ���� ���ư���. �׸��� ���´�. ���� �ƴϳ��ϰ�...

## �ó����� 3

�� �ٸ� �䱸������ ���Դ�. �ٷ� �ٴٿ��� Ż�� �ִ� Ż���� ������ �ϴ� �䱸������ ���� ���̴�.

�׷��� �� �����ڴ� BigFish��� ��ü�� ����� ���� �Ȱ��� ������ �� ���̴�. ������ ���� GameCharacter���ΰ� ������������ �����ϰ� ������ if~else ������ �̷� ��û�� ���� �þ ���̶�� ���� ����ϱ� �����Ѵ�.

���� ���� ������ �� ���� ��Ģ�� �����ϰ� �ִ�.

1. Open-Closed Principle (OCP): ����-��� ��Ģ
2. Liskov Substitution Principle (LSP): �������� ġȯ ��Ģ

2��° �������� ġȯ ��Ģ�� OCP�� ���� ������ �ֱ� ������ ���� ����ϱ� �����.
������ ���� ��ü, �� �θ� ��ü�� ���ǵ� �޼ҵ带 ���� Ŭ���������� �״�� �� �� �־�� �Ѵ�.
�ٵ� �� �ڵ�� �θ��� �޼ҵ带 �������ؼ� ����ϰ� �ִ�. �̰��� �������� ����� OCP�� ���� ������ �ش�.

���� �� �ڵ�� ������ ���� �䱸�� �ݺ��Ǵ� �ڵ� ������ ������ ���̰� ���������� ���� ���������� �ٸ� �䱸���׿� ������ ��ó�� �� ���� �ȴ�.

�׷��ٸ� Strategy Pattern�� ��� ������ �� ���ΰ��� ���� ����� �ؾ��� ����.


�ϴ� ������ ������ ����...�ᱹ �츮�� interface�� ��� ������ �ؾ� �� ������ �� ���̴�.

������ ����� ���ɻ縦 �и��ϴ� �ͺ��� ��������.

ù ��°�δ� Vehicle�̶�� �������� �ϳ��� interface�� ������ ����.

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

�����ϴ�. �׷��ٸ� ���� �� ������ ����ߴ� �䱸 ������ �� ���캸�� ���ذ��� �̾߱� �� �� �ְڴ�.

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
		System.out.println("���Ϳ� ž���մϴ�.");
		
	}

	@Override
	public void move() {
		System.out.println("�ϴ��� ���� �̵��մϴ�.");
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
		System.out.println("���� Ż�Ϳ� ž���մϴ�.");
		
	}

	@Override
	public void move() {
		System.out.println("������ �̵��մϴ�.");
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
		System.out.println("Ż�Ϳ� ž�ϴ�.");
	}
	
	public void move() {
		System.out.println("Ż���� Ÿ�� �̵��մϴ�.");
	}
}
```

���������� GameCharacter�� ������ ���� �ٲ�� �ɰ��̴�.

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

��...�׷��� ���� ���� ��Ȳ���� �ٴٿ��� Ż �� �ִ� ���� ����� �ȴٸ� �츮�� GameCharacter�� ������ �ٲ��� �ʰ� ���� VehicleStrategy�� ���� ��� SeaVehicleStrategy Ŭ������ �����ؼ� ���� GameCharacter�� setVehicle�� �ϴ� �͸����� ��û ������ �߰� �� �� �ְ� �Ǿ���.

���� ������ Ż�Ϳܿ��� �پ��� Ż�͵��� �߰��ϴµ� �־ ���� �������� ��� �ȴ�.

������ � ��û�� ������ �Ǹ� ���� �߰��ϴ� �͸����ε� ���� ������ �������� �ʰ� �����ϰ� Ȯ���� �� �ְ� �Ǿ���.