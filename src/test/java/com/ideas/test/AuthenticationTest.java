package com.ideas.test;

import org.junit.Test;

import com.ideas.ActiveDirectoryUserInfo;
import com.ideas.AuthenticationError;

public class AuthenticationTest {

	@Test(expected = AuthenticationError.class)
	public void userDoesNotExist() throws AuthenticationError {
		String REQUESTEDFIELDS = "employeeNumber,displayName,mail,telephoneNumber,employeeType";
		new ActiveDirectoryUserInfo("ROW\\" + "xyz", REQUESTEDFIELDS);
				
		
	}

}
