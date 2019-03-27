# Interface Segregation Principle (ISP): �������̽� �и� ��Ģ

<h3>
Ŭ���̾�Ʈ�� �ڽ��� �̿����� �ʴ� �޼��忡 �������� �ʾƾ� �Ѵٴ� ��Ģ�̴�.
</h3>

���� ���� �ݴ�� ������ڸ� �� ������ ������ ���� ���� �ǹ̸� ���� �� �ִ�.

<h3>
Ŭ���̾�Ʈ�� �ڽ��� ����ϴ� �޼ҵ忡�� �����ؾ��Ѵٴ� ��Ģ�̴�.
</h3>

## �ó����� 1

���� ���� ������ ���� ���ձ⸦ ���� ���� ���.    
���� û�������ϱ� �� ���� ���� ������ ������ ����ϰ� ��Ʈ���� ���� ���� �Ѵ�.

�ֽ� ��Ʈ�Ͽ��� ��ġ ��ũ���� �ִٰ� ������ �ϰ� notebook�̶�� �������̽��� �����Ѵ�.

���� �ֽ��� ��Ʈ���̶�� �� ��ġ��ũ���� �ִ� �� �ƴ����� ���� �̰� ���� ����̶� �����ؼ� ������ �ϰ� �Ǿ���.

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

�׸��� �ֽ��� 2019�� ��Ʈ���� �����ߴ�.


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
		System.out.println("2019���� �ֽ��� ���÷���");
	}

	@Override
	public void keyboard() {
		System.out.println("2019���� �ֽ��� ������ Ű����");
	}

	@Override
	public void touchScreen() {
		System.out.println("����� ��ġ��ũ�� ����!");		
	}
	
}

```

���� 2019�� �ֽ� ¯¯ ��Ʈ���� ��� �Ǿ���. ���� �������� ��ġ��ũ���� ������ ��Ʈ�����δٰ� �常�� �ߴ�.

## �ó����� 2

�׷��� ����� �ƴ� ������ �ֽ����� �ʿ���� ���� �����θ� �ϸ� �Ǵ� ��Ʈ���� ��û�ߴ�.    
���̴ϱ� ������ �䱸�� ����ֱ� ���ؼ� ������ ���� ������ ����� ��Ʈ���� �ϳ� �����.


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
		System.out.println("2019���� �ֽ��� ���÷���");
	}

	@Override
	public void keyboard() {
		System.out.println("2019���� �ֽ��� ������ Ű����");
	}

	@Override
	public void touchScreen() {
		System.out.println("�� ���� ��ġ ��ũ���� �������� ���� ��ǰ�Դϴ�.");		
	}
	
}


```

�ۼ��ϰ� �ѵ������� ���𰡰� �����ϴٴ� ������ �����. �ֳ��ϸ� ���� �ۼ��� ��Ʈ���� ��ġ��ũ���� ���� ����̶� ���� touchScreen�� �������� �ʾƵ� �Ǳ� �����̴�.

�׷��� �� �޼ҵ带 ����� �翬�� ������ ������ ����. �ֳ��ϸ� �����϶�� �س� �༮�ε� �������� �ʰ� ������ IDE������ ���Ӱ� ǥ�ø� �����ش�.

��Ȯ�ϰ� �����ڸ� ISP�� ������ ���̴�.

ISP�� SRP�� ���� ����߸��� �̾߱� �ϱ� �����.    
�׷��ٸ� �� �ڵ�� ��� �����ؾ� �� ���ΰ�??

�ᱹ SRP�� �԰��ؼ� touchScreen�̶�� ����� �и��ؾ� �� ���̴�.

## �ó����� 3

�ڹٿ����� extends�� ��쿡�� ���� Ȯ�常�� �����Ѵ�. �׷��� �������� ǥ���ϱ� ���ؼ� �츮�� Ȯ���� �ƴ� ������ �����ؾ� �Ѵ�. �ᱹ �������̽��� ��� ������ �ؾ� �Ѵٴ� �ǹ��̴�.

�׷��ٸ� �� �ڵ�� ��ü������ ������ �ؾ� �� �ʿ䰡 �����.


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

���⼭ touchScreen�� �������̽� �и� ��Ģ���� �� �ٸ� �������̽��� ���� ���̴�.

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
		System.out.println("2019���� �ֽ��� ���÷���");
	}

	@Override
	public void keyboard() {
		System.out.println("2019���� �ֽ��� ������ Ű����");
	}
	
}


```

������ NoteBook2017.java�� �������� �ʴ� �޼ҵ忡 ���ؼ��� ������ �ʿ䰡 ���� �Ǿ���.

������ NoteBook2019.java�� �ٸ� ����� �ʿ��ϴ�.

�׷��� �츮�� TouchableScreen�� ������ �ߴ�.

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

������ NoteBook2019�� ���� ����

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
		System.out.println("2019���� �ֽ��� ���÷���");
	}

	@Override
	public void keyboard() {
		System.out.println("2019���� �ֽ��� ������ Ű����");
	}

	@Override
	public void touchScreen() {
		System.out.println("����� ��ġ��ũ�� ����!");		
	}
	
}

```

�ϼ��� �Ǿ���.!

�̷��� interface�� �������ν� touchScreen�� �ش� ��ɿ� ������ ������� �츮�� �ٸ� �ʿ� ������ ���� �ʰ� �Ǿ���.

�̰��� ������ ���� java�� ������ �ִ� ������(polymorphis)�� �����Ѵ�.


## At A Glance

�ǿܷ� �� �κ��� ���� ��ĥ �� �ִ� �κ��̶�� �����Ѵ�.

