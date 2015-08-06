package com.tech.doks.login.svc.impl;

import com.tech.doks.constants.Constants;
import com.tech.doks.login.svc.LoginService;

public class LoginServiceImpl implements LoginService {

	public boolean authenticate(String userName, String password) {
		System.out.println(" Impl:: " + this);
		boolean retVal = false;
		if (userName.equals(Constants.USERNAME_TEST_VALUE)
				&& password.equals(Constants.PASSWORD_TEST_VALUE)) {
			retVal = true;
		}

		return retVal;
	}

}
