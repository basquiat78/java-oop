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
