# Java Encapsulation

���� �Ⱓ ������Ʈ ������ ����� �״ٺ��� ������ �ش� �͵��� ����.    
��¼�� Go To Basic�� �ؾ��ϴ� ������ �Դٴ� ���� ���������� ������ �ȴ�.    


�׵��� �˰� �ִ� �͵��� ������ ����ϸ鼭 ������ �ؿԴ°���� �ڹ��� �� ���ٸ� ���� �°� ���� Ʋ���ٰ� �ڴ��� �ϰ� �Ǵµ� �� �� �ϳ��� �ٷ� ĸ��ȭ�� ���õ� �κ��̴�.

ĸ��ȭ�� �̾߱��� �� �׻� ����ȭ�� �������� �ֱ��ϰ� �Ѵ�.

������ �̷� �̾߱�� ���۽��� ���ؼ� �������� �� �� �ִ� �κ��̴� ���������� �����ϸ鼭 �´�Ҵ� �κп� ���ؼ��� ������ ���� �����̴�.    


## �ó����� 1

�� �ô�� ����� �ô��̰� ���� ������ ����ϰ� �ִ�. ������ �׷� ������ ������ ������ �ΰ� ���� �ʰ� ������ ���� Ư�� ��Ż翡 ���� �ٸ��� ��޵��� ���ؼ� �ο��Ǵ� �������� �پ��ϴٴ� ���� �� �� �ִ�.    

�׷��ٸ� ���� �̾߱��ϴ°� ĸ��ȭ�� ���� ����� �ִ��Ĵ� ������ ���ٵ� �̰��� Ȯ���� ĸ��ȭ�� �����ϱ⿡ ���� ���� �ó������̴�.

```
package io.basquiat.encapsulation;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * created by basquiat
 *
 */
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Coupon {

	/**
	 * ���� ���� �ѹ�
	 */
	private String couponId;
	
	/**
	 * ������ �����ϴ� ��Ż�
	 */
	private String mobileCarrier;
	
	/**
	 * ������ �����ϴ� �귣��
	 */
	private String brand;
	
	/**
	 * ���� ��ȿ �Ⱓ
	 */
	private Date expiryDate;
	
}


```

�� ������ ���� ������ �ִٰ� ����.    
���� �ܼ��� ���� Ŭ�����̴�.

�츮�� ������ ���� �ڵ带 ���ؼ� �ش� ������ ����ϴµ� ���� ��ȿ�Ⱓ�� üũ�ϴ� ������ ����� �� ���� ���̴�.    

```
package io.basquiat.encapsulation;

import java.util.Date;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coupon coupon = Coupon.builder().couponId(UUID.randomUUID().toString())
										.brand("VIPS")
										.mobileCarrier("SKT")
										.expiryDate(new Date())
										.build();
		
		if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 1000000000) {
			System.out.println("��ȿ�� ����");
		} else {
			System.out.println("����� ����");
		}
		
	}

}

```
�ڵ�� �и� ������ ���� �ʴ´�.   
������ �̷� �ڵ尡 �������� ���ȴٰ� ������ ����.
A.java, B.java ���񽺿��� �� �ڵ���� ���ǰ� �ִ� ��Ȳ����    

```
coupon.getExpiryDate().getTime() < 1000000000
```

�� ������ �ٲ��ٰ� �Ѵٸ� �츮�� �ش� �ڵ尡 �� �κ��� ã�Ƽ� �����ϸ� �׸��̴�.    
������ ���� 2���̴� ���� ���� ���̶� ���������� ���� �� ���񽺸� �����ϴ� ���� �������ٸ� �̰��� 100% ���ٺ��� ���� �����ϰ� �ȴ�.

�� �� ���� ������ ����ȴٰ� ������ �غ���.    
���� ��� ������ ���� �ڵ嵵 ���� �� �ִ�.

```
if("SKT".equals(coupon.getMobileCarrier()) {
	if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 1000000000) {
	...
} else if("KT".equals(coupon.getMobileCarrier()) {
	if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 2000000000) {
```

���� ���°� ���� ���ǿ� ���� ���� ���� ��ȿ�Ⱓ�� ������ �� �ִٰ� �����Ѵٸ� �̰��� ���� if ���� �Ǵ� �ϳ��� if���� ��ø�� ������ �����ϰ� �ȴ�.    

## �ó����� 2

�̷� ��Ȳ�� �ȴٸ� �� ������ ����ǰų� �߰��ɶ����� �� �ڵ尡 ���ٺ��� ��� ���񽺴� ���� ����Ǿ��ϰ� �̰��� ������ �ϰ� �ȴ�.    
��� ó���ؾ��ұ�?    

��ü�� �ٽ��� ����� �����ϴ� ���̶�� �� �� �ִ�.    
�׷��ٸ� ���� ������ ����ϴ� ���忡�� ����ϴ°� �ƴ϶� ��ü�� �� ����� �����ϴ� ������� �ٲ�� �ȴ�.    

```
package io.basquiat.encapsulation;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * created by basquiat
 *
 */
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Coupon {

	/**
	 * ���� ���� �ѹ�
	 */
	private String couponId;
	
	/**
	 * ������ �����ϴ� ��Ż�
	 */
	private String mobileCarrier;
	
	/**
	 * ������ �����ϴ� �귣��
	 */
	private String brand;
	
	/**
	 * ���� ��ȿ �Ⱓ
	 */
	private Date expiryDate;
	
	/**
	 * �ش� ������ ��ȿ���� �ƴ��� �˷��ִ� ���
	 * @return boolean
	 */
	public boolean isExpiryDate() {
		boolean isExpiryDate = true;
		
		if(this.getExpiryDate() != null && this.getExpiryDate().getTime() < 1000000000) {
			isExpiryDate = true;
		} else {
			isExpiryDate = false;
		}
		
		return isExpiryDate;
	}
}

```

�츮�� ������ ���� �ش� ������ ��ȿ���� �ƴ����� ���ؼ��� ������ �ִ�.     
�� ���ɿ� ���� ����� �����ϸ� ������ ���� �ڵ尡 ����������.

```
package io.basquiat.encapsulation;

import java.util.Date;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coupon coupon = Coupon.builder().couponId(UUID.randomUUID().toString())
										.brand("VIPS")
										.mobileCarrier("SKT")
										.expiryDate(new Date())
										.build();
		
		if(coupon.isExpiryDate()) {
			System.out.println("��ȿ�� ����");
		} else {
			System.out.println("����� ����");
		}
		
	}

}
```
�̷��� �ڵ��� �ϰ� �Ǹ� ���ǿ��� ���� ���� ������ �ۼ��ϰ� �Ǹ� ���̴�.    
�̷��� �Ǹ� � ���ǵ��� �ٲ� �� �츮�� ���� Coupon�� isExpiryDate()�� �����ϸ� �ȴ�.    

## ĸ��ȭ�� ��Ģ

�츮�� �ܼ������� ���� ���� �ڵ��� ���ؼ� 2���� ��Ģ�� �����ϰ� �ȴ�.

1. Just Tell, Don't Ask

�� ó�� ����� Coupon�̶�� ��ü�κ��� �����͸� ��� if ������ ����ߴ�.    
������ ĸ��ȭ�� ��ü�� �ܼ��ϰ� isExpiryDate��� �޼����� ������ �ִ�. (Thinking Java������ �޼ҵ带 Call�� �ƴ϶� send��� ǥ���Ѵ�.)     
�̰����� ����� ����. �׳� ��û�ض�.    

2. Law Of Demeter

�� ó�� ��Ŀ��� ������ ����

```
if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 1000000000) {
```

�� �ڵ�� �и� �����ϴµ� ���� ������ ����.

������ ��ü���� �����͸� ����ϴ� coupon.getExpiryDate()���� ���� Ÿ���� Date���� �� �ٽ� getTime()�̶�� �޼ҵ带 ȣ���ϰ� �ִ�.

�̰��� Law Of Demeter�� ��Ģ�� ���� �ִ�.     

���� ��ü �ڵ�� ������ ���� �����Ǿ�� �Ѵ�.    

�ᱹ ������ �߽��� ���� ���⺸�ٴ� ��ü ������ �������� �ٶ���� �Ѵ�.

��ü �ڵ�
```
package io.basquiat.encapsulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * created by basquiat
 *
 */
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Coupon {

	/**
	 * ���� ���� �ѹ�
	 */
	private String couponId;
	
	/**
	 * ������ �����ϴ� ��Ż�
	 */
	private String mobileCarrier;
	
	/**
	 * ������ �����ϴ� �귣��
	 */
	private String brand;
	
	/**
	 * ���� ��ȿ �Ⱓ
	 */
	private long expiryDate;
	
	/**
	 * �ش� ������ ��ȿ���� �ƴ��� �˷��ִ� ���
	 * @return boolean
	 */
	public boolean isExpiryDate() {
		boolean isExpiryDate = true;
		
		if(this.getExpiryDate() != 0 && this.getExpiryDate() < 1000000000) {
			isExpiryDate = true;
		} else {
			isExpiryDate = false;
		}
		
		return isExpiryDate;
	}
}
```

```
package io.basquiat.encapsulation;

import java.util.Date;
import java.util.UUID;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coupon coupon = Coupon.builder().couponId(UUID.randomUUID().toString())
										.brand("VIPS")
										.mobileCarrier("SKT")
										.expiryDate(new Date().getTime())
										.build();
		
		System.out.println(coupon);
		if(coupon.isExpiryDate()) {
			System.out.println("��ȿ�� ����");
		} else {
			System.out.println("����� ����");
		}
		
	}

}

```
