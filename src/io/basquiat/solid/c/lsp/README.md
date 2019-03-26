# Liskov Substitution Principle (LSP): 리스코프 치환 원칙

<h3>
상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.
</h3>


## 시나리오 1

LSP와 관련된 예제중 가장 유명한 것은 Rectancle, Square 예제이다.
하지만 다음과 같이 심플한 예제를 적용해 보자.

Animal.java

```
package io.basquiat.solid.c.lsp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Animal {

	public void cry() {
		System.out.println("동물이 울고 있습니다.");
	}

	public void eat() {
		System.out.println("동물이 먹이를 맛있게 냠냠!");
	}
	
}

```

심플하게 동물이라는 객체를 만든다. 가장 기본적인 행위인 운다는 행위와 먹는다는 행위를 정의를 했다.

그리고 기본적인 동물인 고양이와 개를 정의해 보자.


Dog.java

```
package io.basquiat.solid.c.lsp.model;

import lombok.Getter;

/**
 * 
 * created by basquiat
 *
 */
public class Dog extends Animal {

	@Getter
	private boolean isStarve;

	@Override
	public void cry() {
		System.out.println("강아지가 멍멍~ 하고 울고 있습니다.");
	}

	@Override
	public void eat() {
		System.out.println("강아지가 먹이를 맛있게 냠냠!");
	}

}

```

Cat.java

```
package io.basquiat.solid.c.lsp.model;

/**
 * 
 * created by basquiat
 *
 */
public class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("고양이가 냐옹~ 하고 울고 있습니다.");
	}

	@Override
	public void eat() {
		System.out.println("고양이가 먹이를 맛있게 냠냠!");
	}

}

```

Main.java

```
package io.basquiat.solid.c.lsp;

import io.basquiat.solid.c.lsp.model.Animal;
import io.basquiat.solid.c.lsp.model.Cat;
import io.basquiat.solid.c.lsp.model.Dog;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal cat = new Cat();
		cat.cry();
		cat.eat();
		
		Animal dog = new Dog();
		dog.cry();
		dog.eat();
		
	}

}

```

자 여기까지는 단순한 코드이다. 누구라도 할 수 있다. 어떤 법칙도 위반하지 않고 있다.

## 시나리오 2

Dog를 상속받는 강아지 장난감을 생성해 보자.

그전에 Dog객체는 다음과 같이 변경이 되었다.

```
package io.basquiat.solid.c.lsp.model;

import lombok.Getter;

/**
 * 
 * created by basquiat
 *
 */
public class Dog extends Animal {

	@Getter
	private boolean isJoyful;

	@Override
	public void cry() {
		System.out.println("강아지가 멍멍~ 하고 울고 있습니다.");
	}

	@Override
	public void eat() {
		System.out.println("강아지가 먹이를 맛있게 냠냠!");
	}

	public void run() {
		isJoyful = true;
		System.out.println("강아지가 뛰어 놉니다.");
	}
}

```

run이라는 메소드가 추가되었고 강아지가 신나게 뛰어 놀기 때문에 강아지의 상태는 joyful이 true로 변경되는 단순한 로직이다.

하지만 강아지 장난감은 이것이 그대로 적용되지 않으니 다음과 같은 코드를 작성할 수 있다.

ToyDog.java

```
package io.basquiat.solid.c.lsp.model;

public class ToyDog extends Dog {

	@Override
	public void cry() {
		System.out.println("강아지 장난감이 멍멍~ 하고 울고 있습니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("강아지 장난감은 먹이를 먹을 수 없습니다.");
	}
	
	@Override
	public void run() {
		System.out.println("강아지 장난감은 뛰어 다닐 수 없습니다.");
	}
	
}


```

실행 단계에서는 어떠한 문제도 발견되지 않고 컴파일 에러도 발생하지 않지만 정확하게 LSP를 위배하고 있다.

이유가 무엇일까?

Dog.java를 다시 살펴보자.


```
	@Getter
	private boolean isJoyful;
.
.
.

	public void run() {
		isJoyful = true;
		System.out.println("강아지가 뛰어 놉니다.");
	}
```

강아지가 뛰어놀면 상태값을 변경하는 코드가 수행되고 있지만 ToyDog에서는 그렇지 않다. 

맨 위의
 
<h3>
상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.
</h3>

이라는 의미를 상기시킨다면 상태값을 조정하는 로직때문에 정상적으로 동작하지 않을 가능성이 다분하다.

사실 run이라는 것은 동물의 공통사항이니 상위 클래스인 Animal에 정의하는 게 맞지만 예제를 위해서 위와 같이 코드를 작성한 것이다.