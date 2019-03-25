package io.basquiat.solid.a.srp;

import java.util.UUID;

import io.basquiat.solid.a.srp.model.User;
import io.basquiat.solid.a.srp.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = User.builder().userId(UUID.randomUUID().toString())
								  .name("basquiat")
								  .nickName("jazzLover")
								  .password("test")
								  .email("funnyjazz@naver.com")
								  .build();
		
		UserService userService = new UserService();
		System.out.println(userService.changeEmail(user, "test@naver.com"));
		
	}

}
