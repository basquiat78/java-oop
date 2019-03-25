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
