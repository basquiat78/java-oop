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
