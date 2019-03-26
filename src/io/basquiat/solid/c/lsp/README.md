# Liskov Substitution Principle (LSP): �������� ġȯ ��Ģ

<h3>
���� Ÿ���� ��ü�� ���� Ÿ���� ��ü�� ġȯ�ص� ���� Ÿ���� ����ϴ� ���α׷��� ���������� �����ؾ� �Ѵ�.
</h3>


## �ó����� 1

LSP�� ���õ� ������ ���� ������ ���� Rectancle, Square �����̴�.
������ ������ ���� ������ ������ ������ ����.

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
		System.out.println("������ ��� �ֽ��ϴ�.");
	}

	public void eat() {
		System.out.println("������ ���̸� ���ְ� �ȳ�!");
	}
	
}

```

�����ϰ� �����̶�� ��ü�� �����. ���� �⺻���� ������ ��ٴ� ������ �Դ´ٴ� ������ ���Ǹ� �ߴ�.

�׸��� �⺻���� ������ ����̿� ���� ������ ����.


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
		System.out.println("�������� �۸�~ �ϰ� ��� �ֽ��ϴ�.");
	}

	@Override
	public void eat() {
		System.out.println("�������� ���̸� ���ְ� �ȳ�!");
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
		System.out.println("����̰� �Ŀ�~ �ϰ� ��� �ֽ��ϴ�.");
	}

	@Override
	public void eat() {
		System.out.println("����̰� ���̸� ���ְ� �ȳ�!");
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

�� ��������� �ܼ��� �ڵ��̴�. ������ �� �� �ִ�. � ��Ģ�� �������� �ʰ� �ִ�.

## �ó����� 2

Dog�� ��ӹ޴� ������ �峭���� ������ ����.

������ Dog��ü�� ������ ���� ������ �Ǿ���.

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
		System.out.println("�������� �۸�~ �ϰ� ��� �ֽ��ϴ�.");
	}

	@Override
	public void eat() {
		System.out.println("�������� ���̸� ���ְ� �ȳ�!");
	}

	public void run() {
		isJoyful = true;
		System.out.println("�������� �پ� ��ϴ�.");
	}
}

```

run�̶�� �޼ҵ尡 �߰��Ǿ��� �������� �ų��� �پ� ��� ������ �������� ���´� joyful�� true�� ����Ǵ� �ܼ��� �����̴�.

������ ������ �峭���� �̰��� �״�� ������� ������ ������ ���� �ڵ带 �ۼ��� �� �ִ�.

ToyDog.java

```
package io.basquiat.solid.c.lsp.model;

public class ToyDog extends Dog {

	@Override
	public void cry() {
		System.out.println("������ �峭���� �۸�~ �ϰ� ��� �ֽ��ϴ�.");
	}
	
	@Override
	public void eat() {
		System.out.println("������ �峭���� ���̸� ���� �� �����ϴ�.");
	}
	
	@Override
	public void run() {
		System.out.println("������ �峭���� �پ� �ٴ� �� �����ϴ�.");
	}
	
}


```

���� �ܰ迡���� ��� ������ �߰ߵ��� �ʰ� ������ ������ �߻����� ������ ��Ȯ�ϰ� LSP�� �����ϰ� �ִ�.

������ �����ϱ�?

Dog.java�� �ٽ� ���캸��.


```
	@Getter
	private boolean isJoyful;
.
.
.

	public void run() {
		isJoyful = true;
		System.out.println("�������� �پ� ��ϴ�.");
	}
```

�������� �پ��� ���°��� �����ϴ� �ڵ尡 ����ǰ� ������ ToyDog������ �׷��� �ʴ�. 

�� ����
 
<h3>
���� Ÿ���� ��ü�� ���� Ÿ���� ��ü�� ġȯ�ص� ���� Ÿ���� ����ϴ� ���α׷��� ���������� �����ؾ� �Ѵ�.
</h3>

�̶�� �ǹ̸� ����Ų�ٸ� ���°��� �����ϴ� ���������� ���������� �������� ���� ���ɼ��� �ٺ��ϴ�.

��� run�̶�� ���� ������ ��������̴� ���� Ŭ������ Animal�� �����ϴ� �� ������ ������ ���ؼ� ���� ���� �ڵ带 �ۼ��� ���̴�.