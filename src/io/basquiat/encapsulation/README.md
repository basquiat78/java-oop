# Java Encapsulation

오랜 기간 프로젝트 위주의 경력을 쌓다보니 가끔씩 잊는 것들이 많다.    
어쩌면 Go To Basic을 해야하는 시점에 왔다는 것을 개인적으로 느끼게 된다.    


그동안 알고 있던 것들을 실제로 사용하면서 개발을 해왔는가라는 자문을 해 본다면 반은 맞고 반은 틀리다고 자답을 하게 되는데 그 중 하나가 바로 캡슐화와 관련된 부분이다.

캡슐화를 이야기할 때 항상 은닉화와 연관지어 애기하곤 한다.

하지만 이런 이야기는 구글신을 통해서 언제든지 알 수 있는 부분이니 개인적으로 개발하면서 맞닿았던 부분에 대해서만 예제로 남길 예정이다.    


## 시나리오 1

현 시대는 모바일 시대이고 많은 쿠폰을 사용하고 있다. 하지만 그런 쿠폰은 영원한 기한을 두고 있지 않고 있으며 또한 특정 통신사에 따라 다르며 등급등을 통해서 부여되는 할인율이 다양하다는 것을 알 수 있다.    

그렇다면 지금 이야기하는게 캡슐화와 무슨 상관이 있느냐는 생각을 할텐데 이것은 확실히 캡슐화를 설명하기에 정말 좋은 시나리오이다.

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
	 * 쿠폰 고유 넘버
	 */
	private String couponId;
	
	/**
	 * 쿠폰을 제공하는 통신사
	 */
	private String mobileCarrier;
	
	/**
	 * 쿠폰을 제공하는 브랜드
	 */
	private String brand;
	
	/**
	 * 쿠폰 유효 기간
	 */
	private Date expiryDate;
	
}


```

자 다음과 같은 쿠폰이 있다고 하자.    
정말 단순한 쿠폰 클래스이다.

우리는 다음과 같은 코드를 통해서 해당 쿠폰을 사용하는데 쿠폰 유효기간을 체크하는 로직을 사용할 수 있을 것이다.    

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
			System.out.println("유효한 쿠폰");
		} else {
			System.out.println("만료된 쿠폰");
		}
		
	}

}

```
코드는 분명 문제가 되지 않는다.   
하지만 이런 코드가 여기저기 사용된다고 생각해 보자.
A.java, B.java 서비스에서 이 코드들이 사용되고 있는 상황에서    

```
coupon.getExpiryDate().getTime() < 1000000000
```

이 조건이 바꼈다고 한다면 우리는 해당 코드가 들어간 부분을 찾아서 수정하면 그만이다.    
하지만 단지 2개이니 별일 없을 것이라 생각하지만 만일 이 서비스를 제공하는 곳이 많아진다면 이것은 100% 복붙복의 헬을 경험하게 된다.

또 몇 가지 조건이 변경된다고 생각을 해보자.    
예를 들면 다음과 같은 코드도 있을 수 있다.

```
if("SKT".equals(coupon.getMobileCarrier()) {
	if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 1000000000) {
	...
} else if("KT".equals(coupon.getMobileCarrier()) {
	if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 2000000000) {
```

감이 오는가 저런 조건에 따라서 만일 쿠폰 유효기간이 증가될 수 있다고 가정한다면 이것은 이중 if 조건 또는 하나의 if문에 중첩된 조건을 나열하게 된다.    

## 시나리오 2

이런 상황이 된다면 매 조건이 변경되거나 추가될때마다 이 코드가 복붙복된 모든 서비스는 전부 변경되야하고 이것은 삽질을 하게 된다.    
어떻게 처리해야할까?    

객체의 핵심은 기능을 제공하는 것이라고 알 고 있다.    
그렇다면 저런 조건을 사용하는 입장에서 사용하는게 아니라 객체가 그 기능을 제공하는 방식으로 바뀌면 된다.    

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
	 * 쿠폰 고유 넘버
	 */
	private String couponId;
	
	/**
	 * 쿠폰을 제공하는 통신사
	 */
	private String mobileCarrier;
	
	/**
	 * 쿠폰을 제공하는 브랜드
	 */
	private String brand;
	
	/**
	 * 쿠폰 유효 기간
	 */
	private Date expiryDate;
	
	/**
	 * 해당 쿠폰이 유효한지 아닌지 알려주는 기능
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

우리의 관심은 단지 해당 쿠폰이 유효한지 아닌지에 대해서만 관심이 있다.     
그 관심에 대한 기능을 제공하면 다음과 같이 코드가 간결해진다.

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
			System.out.println("유효한 쿠폰");
		} else {
			System.out.println("만료된 쿠폰");
		}
		
	}

}
```
이렇게 코딩을 하게 되면 조건에서 위와 같이 로직을 작성하게 되면 끝이다.    
이렇게 되면 어떤 조건들이 바뀔 때 우리는 단지 Coupon의 isExpiryDate()만 수정하면 된다.    

## 캡슐화의 규칙

우리는 단순하지만 위와 같은 코딩을 통해서 2가지 규칙을 적용하게 된다.

1. Just Tell, Don't Ask

맨 처음 방식은 Coupon이라는 객체로부터 데이터를 물어서 if 조건을 사용했다.    
하지만 캡슐화는 객체에 단순하게 isExpiryDate라는 메세지를 보내고 있다. (Thinking Java에서는 메소드를 Call이 아니라 send라고 표현한다.)     
이것저것 물어보지 마라. 그냥 요청해라.    

2. Law Of Demeter

맨 처음 방식에서 조건을 보면

```
if(coupon.getExpiryDate() != null && coupon.getExpiryDate().getTime() < 1000000000) {
```

이 코드는 분명 수행하는데 전혀 문제가 없다.

하지만 객체에게 데이터를 요규하는 coupon.getExpiryDate()에서 리턴 타입인 Date에서 또 다시 getTime()이라는 메소드를 호출하고 있다.

이것은 Law Of Demeter의 법칙을 어기고 있다.     

따라서 전체 코드는 다음과 같이 수정되어야 한다.    

결국 데이터 중심의 절차 지향보다는 객체 지향의 관점에서 바라봐야 한다.

전체 코드
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
	 * 쿠폰 고유 넘버
	 */
	private String couponId;
	
	/**
	 * 쿠폰을 제공하는 통신사
	 */
	private String mobileCarrier;
	
	/**
	 * 쿠폰을 제공하는 브랜드
	 */
	private String brand;
	
	/**
	 * 쿠폰 유효 기간
	 */
	private long expiryDate;
	
	/**
	 * 해당 쿠폰이 유효한지 아닌지 알려주는 기능
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
			System.out.println("유효한 쿠폰");
		} else {
			System.out.println("만료된 쿠폰");
		}
		
	}

}

```
