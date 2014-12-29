package com.mmup;

import com.mmup.businessrules.LoginBusinessRule;

public class WebServices {	
	
	public String authenticate(AuthenticateInput authenticateInput)
	{
		String errorCodes =	new LoginBusinessRule().validateCrednetials(authenticateInput.login, authenticateInput.password);
		if(errorCodes.equals("Failed"))
		{
			errorCodes = "Failed";
		}	
		return errorCodes;
	}
	
	public String getTaskDetailsById()
	{
		return "";
	}

}
