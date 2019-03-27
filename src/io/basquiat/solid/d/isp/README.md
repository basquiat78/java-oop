# Interface Segregation Principle (ISP): 인터페이스 분리 원칙

<h3>
클라이언트가 자신이 이용하지 않는 메서드에 의존하지 않아야 한다는 원칙이다.
</h3>

말이 어려운데 반대로 얘기하자면 저 명제는 다음과 같이 같은 의미를 지닐 수 있다.

<h3>
클라이언트는 자신이 사용하는 메소드에만 의존해야한다는 원칙이다.
</h3>

## 시나리오 1

가장 많은 예제가 보통 복합기를 예로 많이 든다.    
나는 청개구리니깐 그 예제 말고 생각한 예제는 비슷하게 노트북을 예로 들어볼까 한다.

최신 노트북에는 터치 스크린이 있다고 가정을 하고 notebook이라는 인터페이스를 생성한다.

물론 최신형 노트북이라고 다 터치스크린이 있는 건 아니지만 나는 이게 멋진 기능이라 생각해서 구현을 하게 되었다.

NoteBook.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public interface NoteBook {

	public void display();
	
	public void keyboard();
	
	public void touchScreen();
	
}


```

그리고 최신형 2019년 노트북을 생성했다.


NoteBook2019.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2019 implements NoteBook {

	@Override
	public void display() {
		System.out.println("2019년형 최신형 디스플레이");
	}

	@Override
	public void keyboard() {
		System.out.println("2019년형 최신형 감도의 키보드");
	}

	@Override
	public void touchScreen() {
		System.out.println("우아한 터치스크린 장착!");		
	}
	
}

```

드디어 2019년 최신 짱짱 노트북을 얻게 되었다. 무려 간지나는 터치스크린을 장착한 노트북으로다가 장만을 했다.

## 시나리오 2

그러던 어느날 아는 동생이 최신형은 필요없고 그저 웹쇼핑만 하면 되는 노트북을 요청했다.    
형이니깐 동생의 요구를 들어주기 위해서 다음과 같이 적당한 년식의 노트북을 하나 만든다.


NoteBook2017.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2017 implements NoteBook {

	@Override
	public void display() {
		System.out.println("2019년형 최신형 디스플레이");
	}

	@Override
	public void keyboard() {
		System.out.println("2019년형 최신형 감도의 키보드");
	}

	@Override
	public void touchScreen() {
		System.out.println("이 모델은 터치 스크린이 장착되지 않은 제품입니다.");		
	}
	
}


```

작성하고 뿌듯했지만 무언가가 찝찝하다는 느낌이 들었다. 왜냐하면 지금 작성한 노트북은 터치스크린이 없는 사양이라 굳이 touchScreen을 구현하지 않아도 되기 때문이다.

그래서 저 메소드를 지우면 당연히 컴파일 에러가 난다. 왜냐하면 구현하라고 해논 녀석인데 구현하지 않고 있으니 IDE에서는 뻘겋게 표시를 보여준다.

정확하게 말하자면 ISP를 위반한 것이다.

ISP는 SRP와 따로 떨어뜨리고 이야기 하기 힘들다.    
그렇다면 위 코드는 어떻게 수정해야 할 것인가??

결국 SRP에 입각해서 touchScreen이라는 기능을 분리해야 할 것이다.

## 시나리오 3

자바에서는 extends의 경우에는 단일 확장만을 지원한다. 그래서 다형성을 표현하기 위해서 우리는 확장이 아닌 구현에 집중해야 한다. 결국 인터페이스에 대고 개발을 해야 한다는 의미이다.

그렇다면 위 코드는 전체적으로 수정을 해야 할 필요가 생겼다.


NoteBook.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public interface NoteBook {

	public void display();
	
	public void keyboard();
	
}

```

여기서 touchScreen은 인터페이스 분리 원칙으로 또 다른 인터페이스로 나눌 것이다.

NoteBook2017.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2017 implements NoteBook {

	@Override
	public void display() {
		System.out.println("2019년형 최신형 디스플레이");
	}

	@Override
	public void keyboard() {
		System.out.println("2019년형 최신형 감도의 키보드");
	}
	
}


```

기존의 NoteBook2017.java는 구현하지 않는 메소드에 대해서는 구현할 필요가 없게 되었다.

하지만 NoteBook2019.java는 다른 방법이 필요하다.

그래서 우리는 TouchableScreen를 만들기로 했다.

TouchableScreen.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public interface TouchableScreen {

	public void touchScreen();
	
}


```

이제는 NoteBook2019를 손을 보자

NoteBook2019.java

```
package io.basquiat.solid.d.isp.model;

/**
 * 
 * created by basquiat
 *
 */
public class NoteBook2019 implements NoteBook, TouchableScreen {

	@Override
	public void display() {
		System.out.println("2019년형 최신형 디스플레이");
	}

	@Override
	public void keyboard() {
		System.out.println("2019년형 최신형 감도의 키보드");
	}

	@Override
	public void touchScreen() {
		System.out.println("우아한 터치스크린 장착!");		
	}
	
}

```

완성이 되었다.!

이렇게 interface를 나눔으로써 touchScreen의 해당 기능에 변경이 생기더라도 우리는 다른 쪽에 영향을 주지 않게 되었다.

이것이 가능한 것은 java가 가지고 있는 다형성(polymorphis)에 기인한다.


## At A Glance

의외로 이 부분은 많이 놓칠 수 있는 부분이라고 생각한다.

