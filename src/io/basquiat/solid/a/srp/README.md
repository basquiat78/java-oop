# Single Responsibility Principle (SRP): 단일 책임 원칙

<h3>
클래스는 단 한 개의 책임을 가져야 한다.
</h3>

아마도 개인적으로 가장 잘 안지켜지는 부분이라고 생각한다.    

## 시나리오 1

어떤 Application이 있다고 생각하자.     
이 app에는 user가 이메일 변경 또는 비번을 변경하는 프로세스가 있고 그것과 관련된 UserService가 있다고 보는 것이다.

일반적으로 다음과 같은 코드를 맨처음 짜게 되는 것 같다.     

User.java

```
package io.basquiat.solid.a.srp.model;

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
public class User {

	/**
	 * userId
	 */
	private String userId;
	
	/**
	 * userName
	 */
	private String name;
	
	/**
	 * nickname
	 */
	private String nickName;
	
	/**
	 * password
	 */
	private String password;
	
	/**
	 * email
	 */
	private String email;
	
}

```


UserService.java

```
package io.basquiat.solid.a.srp.service;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserService {

	/**
	 * 비번 변경
	 * @param user
	 * @param password
	 * @return User
	 */
	public User changePassword(User user, String password) {
		//Do Something
		// e.g update DB User Table
		return user;
	}
	
	/**
	 * 이메일 변경
	 * @param user
	 * @param email
	 * @return User
	 */
	public User changeEmail(User user, String email) {
		//Do Something
		// e.g update DB User Table
		return user;
	}
	
	/**
	 * 닉네임 변경
	 * @param user
	 * @param nickName
	 * @return User
	 */
	public User changeNickName(User user, String nickName) {
		//Do Something
		// e.g update DB User Table	
		return user;
	}
	
}

```

하지만 이걸로는 부족하다. 일반적으로 어떤 사이트에서 비번, 이메일, 닉네임을 변경시에는 비번을 다시 묻는다는가 하는 형식으로 어떤 체크 로직을 타게 되어 있다.    

이렇게 되면 우리는 다음과 같이 관습적으로 코딩하는 경향이 있다. (물론 다는 아니라는 거...)    

```
package io.basquiat.solid.a.srp.service;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserService {

	/**
	 * 비번 변경
	 * @param user
	 * @param password
	 * @return User
	 */
	public User changePassword(User user, String password) {
		if(this.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			return user;
		}
		return user;
	}
	
	/**
	 * 이메일 변경
	 * @param user
	 * @param email
	 * @return User
	 */
	public User changeEmail(User user, String email) {
		if(this.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			return user;
		}
		return user;
	}
	
	/**
	 * 닉네임 변경
	 * @param user
	 * @param nickName
	 * @return User
	 */
	public User changeNickName(User user, String nickName) {
		if(this.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			return user;
		}
		return user;
	}
	
	/**
	 * session으로부터 무언가를 체크한다.
	 * @param user
	 * @return boolean
	 */
	public boolean checkUserIdentity(User user) {
		boolean checkIdentity = true;
		//Do Something
		// e.g sesssion check
		return checkIdentity;
		
	}
	
}


```

가만보면 아무 문제 없는 코드이다.    
나는 단지 어떤 로직으로 유효한지 체크하는 로직을 태우고 그 조건이 성립되면 이메일, 닉네임, 비번을 변경하는 코드를 수행했을 뿐이다.     
이 상태로는 아무 문제가 없다.     

하지만 뭐가 문제일까?

UserService라는 것은 user와 관련된 서비스 즉, 가입, 탈퇴, 개인정보 수정을 제공하는 서비스라고 가정한다면 정확하게 이것은     
<h3>
클래스는 단 한 개의 책임을 가져야 한다.
</h3>
를 위배하고 있다.     

왜일까?     

UserService는 하나의 책임을 가져야 한다는 의미에서 유저의 정보에 대한 책임만 져야 한다는 것이다. 하지만 이 서비스에는 유저의 유효성을 체크하는 책임, 즉 2 가지의 책임을 가지고 있다.     

또 한 이렇게 되면서 만일 다른 서비스에서 똑같은 형태로 유저의 유효성을 체크하는 로직을 사용하기 위해서라면 우리는 이 서비스는 @Autowired해서 이 서비스를 DI한다.     

다른 건 필요없고 저 하나의 기능을 위해서 user의 대한 전반적인 서비스를 제공하는 객체를 DI하는 것은 낭비라고 볼 수 있다.


두 가지 방식을 적용해 볼 수 있다. 하나는 Utility성으로 빼는 것과 관심을 분리해서 하나의 서비스로 분리하는 방법이다.    

하지만 개인적으로 나는 Utility로 빼는 것보다는 서비스로 분리하는 것을 선호한다.

예를 들면 다음과 같은 방식을 적용해 볼 수 있겠다.

```
package io.basquiat.solid.a.srp.model.util;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserUtil {

	/**
	 * 유효성을 체크한다.
	 * @param user
	 * @return boolean
	 */
	public static boolean checkUserIdentity(User user) {
		boolean checkIdentity = true;
		//Do Something
		// e.g sesssion check
		return checkIdentity;
	}

}

```

일단은 관심과 책임을 분리했다는 점에서는 나이스하다. 하지만 언제나 변경에 대해서는 고려를 해야한다.

만일 세션이 아닌 다른 repository로부터 무언가를 수행해야한다면 차라리 서비스로 분리하는게 좀 더 유연하게 대처할 수 있기 때문이다.


```
package io.basquiat.solid.a.srp.service;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserAccessService {

	/**
	 * session으로부터 무언가를 체크한다.
	 * 또는 다른 repository를 통해서 무언가를 수행한다.
	 * @param user
	 * @return boolean
	 */
	public boolean checkUserIdentity(User user) {
		boolean checkIdentity = true;
		//Do Something
		// e.g sesssion check or from repository
		return checkIdentity;
		
	}
	
}

```

최종 코드


UserService.java

```
package io.basquiat.solid.a.srp.service;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserService {

	private UserAccessService userAccessService;
	
	public UserService() {
		userAccessService = new UserAccessService();
	}
	
	/**
	 * 비번 변경
	 * @param user
	 * @param password
	 * @return User
	 */
	public User changePassword(User user, String password) {
		if(userAccessService.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			user.setPassword(password);
			return user;
		}
		return user;
	}
	
	/**
	 * 이메일 변경
	 * @param user
	 * @param email
	 * @return User
	 */
	public User changeEmail(User user, String email) {
		if(userAccessService.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			user.setEmail(email);
			return user;
		}
		return user;
	}
	
	/**
	 * 닉네임 변경
	 * @param user
	 * @param nickName
	 * @return User
	 */
	public User changeNickName(User user, String nickName) {
		if(userAccessService.checkUserIdentity(user)) {
			//Do Something
			// e.g update DB User Table
			user.setNickName(nickName);
			return user;
		}
		return user;
	}
	
}

```


UserAccessService.java

```
package io.basquiat.solid.a.srp.service;

import io.basquiat.solid.a.srp.model.User;

/**
 * 
 * created by basquiat
 *
 */
public class UserAccessService {

	/**
	 * session으로부터 무언가를 체크한다.
	 * 또는 다른 repository를 통해서 무언가를 수행한다.
	 * @param user
	 * @return boolean
	 */
	public boolean checkUserIdentity(User user) {
		boolean checkIdentity = false;
		//Do Something
		// e.g sesssion check or from repository
		return checkIdentity;
		
	}
	
}
```

처음 자바를 배울 때의 강사가 했던 말들이 거의 10년이 다 되가는 경력이 되서야 하나씩 떠오르기 시작한다.    
모든 것은 우리가 관찰을 얼마나 잘하고 관심과 책임을 얼마나 잘 분리할 수 있느냐에 따라서 OOP에 대한 성숙도가 결정된다는 사실을 말이다.    

단순하기 그지없지만 잘 지켜지지 않는다는 점에서 다시 한번 곱씹어 보게 된다.


# At A Glance

이 예제는 잘 살펴보면 AOP를 적용할 수 있는 부분이 있다.     
관점이라는 측면에서 해당 로직들은 반복되는 checkUserIdentity메소드를 호출하고 있기 때문이다.


이러한 로직을 전부 분리하고 AOP를 적용하면 위의 반복되는 if문들 역시 사라지겠지...