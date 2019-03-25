# Single Responsibility Principle (SRP): ���� å�� ��Ģ

<h3>
Ŭ������ �� �� ���� å���� ������ �Ѵ�.
</h3>

�Ƹ��� ���������� ���� �� ���������� �κ��̶�� �����Ѵ�.    

## �ó����� 1

� Application�� �ִٰ� ��������.     
�� app���� user�� �̸��� ���� �Ǵ� ����� �����ϴ� ���μ����� �ְ� �װͰ� ���õ� UserService�� �ִٰ� ���� ���̴�.

�Ϲ������� ������ ���� �ڵ带 ��ó�� ¥�� �Ǵ� �� ����.     

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
	 * ��� ����
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
	 * �̸��� ����
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
	 * �г��� ����
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

������ �̰ɷδ� �����ϴ�. �Ϲ������� � ����Ʈ���� ���, �̸���, �г����� ����ÿ��� ����� �ٽ� ���´ٴ°� �ϴ� �������� � üũ ������ Ÿ�� �Ǿ� �ִ�.    

�̷��� �Ǹ� �츮�� ������ ���� ���������� �ڵ��ϴ� ������ �ִ�. (���� �ٴ� �ƴ϶�� ��...)    

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
	 * ��� ����
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
	 * �̸��� ����
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
	 * �г��� ����
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
	 * session���κ��� ���𰡸� üũ�Ѵ�.
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

�������� �ƹ� ���� ���� �ڵ��̴�.    
���� ���� � �������� ��ȿ���� üũ�ϴ� ������ �¿�� �� ������ �����Ǹ� �̸���, �г���, ����� �����ϴ� �ڵ带 �������� ���̴�.     
�� ���·δ� �ƹ� ������ ����.     

������ ���� �����ϱ�?

UserService��� ���� user�� ���õ� ���� ��, ����, Ż��, �������� ������ �����ϴ� ���񽺶�� �����Ѵٸ� ��Ȯ�ϰ� �̰���     
<h3>
Ŭ������ �� �� ���� å���� ������ �Ѵ�.
</h3>
�� �����ϰ� �ִ�.     

���ϱ�?     

UserService�� �ϳ��� å���� ������ �Ѵٴ� �ǹ̿��� ������ ������ ���� å�Ӹ� ���� �Ѵٴ� ���̴�. ������ �� ���񽺿��� ������ ��ȿ���� üũ�ϴ� å��, �� 2 ������ å���� ������ �ִ�.     

�� �� �̷��� �Ǹ鼭 ���� �ٸ� ���񽺿��� �Ȱ��� ���·� ������ ��ȿ���� üũ�ϴ� ������ ����ϱ� ���ؼ���� �츮�� �� ���񽺴� @Autowired�ؼ� �� ���񽺸� DI�Ѵ�.     

�ٸ� �� �ʿ���� �� �ϳ��� ����� ���ؼ� user�� ���� �������� ���񽺸� �����ϴ� ��ü�� DI�ϴ� ���� ������ �� �� �ִ�.


�� ���� ����� ������ �� �� �ִ�. �ϳ��� Utility������ ���� �Ͱ� ������ �и��ؼ� �ϳ��� ���񽺷� �и��ϴ� ����̴�.    

������ ���������� ���� Utility�� ���� �ͺ��ٴ� ���񽺷� �и��ϴ� ���� ��ȣ�Ѵ�.

���� ��� ������ ���� ����� ������ �� �� �ְڴ�.

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
	 * ��ȿ���� üũ�Ѵ�.
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

�ϴ��� ���ɰ� å���� �и��ߴٴ� �������� ���̽��ϴ�. ������ ������ ���濡 ���ؼ��� ����� �ؾ��Ѵ�.

���� ������ �ƴ� �ٸ� repository�κ��� ���𰡸� �����ؾ��Ѵٸ� ���� ���񽺷� �и��ϴ°� �� �� �����ϰ� ��ó�� �� �ֱ� �����̴�.


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
	 * session���κ��� ���𰡸� üũ�Ѵ�.
	 * �Ǵ� �ٸ� repository�� ���ؼ� ���𰡸� �����Ѵ�.
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

���� �ڵ�


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
	 * ��� ����
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
	 * �̸��� ����
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
	 * �г��� ����
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
	 * session���κ��� ���𰡸� üũ�Ѵ�.
	 * �Ǵ� �ٸ� repository�� ���ؼ� ���𰡸� �����Ѵ�.
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

ó�� �ڹٸ� ��� ���� ���簡 �ߴ� ������ ���� 10���� �� �ǰ��� ����� �Ǽ��� �ϳ��� �������� �����Ѵ�.    
��� ���� �츮�� ������ �󸶳� ���ϰ� ���ɰ� å���� �󸶳� �� �и��� �� �ִ��Ŀ� ���� OOP�� ���� �������� �����ȴٴ� ����� ���̴�.    

�ܼ��ϱ� ���������� �� �������� �ʴ´ٴ� ������ �ٽ� �ѹ� ���þ� ���� �ȴ�.


# At A Glance

�� ������ �� ���캸�� AOP�� ������ �� �ִ� �κ��� �ִ�.     
�����̶�� ���鿡�� �ش� �������� �ݺ��Ǵ� checkUserIdentity�޼ҵ带 ȣ���ϰ� �ֱ� �����̴�.


�̷��� ������ ���� �и��ϰ� AOP�� �����ϸ� ���� �ݺ��Ǵ� if���� ���� ���������...