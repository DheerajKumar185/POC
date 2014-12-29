package com.mmup;

public class AuthenticateInput {
	
	String login;
	String password;
	String identityContext;
	String onBehalfOfUser;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentityContext() {
		return identityContext;
	}
	public void setIdentityContext(String identityContext) {
		this.identityContext = identityContext;
	}
	public String getOnBehalfOfUser() {
		return onBehalfOfUser;
	}
	public void setOnBehalfOfUser(String onBehalfOfUser) {
		this.onBehalfOfUser = onBehalfOfUser;
	}

}