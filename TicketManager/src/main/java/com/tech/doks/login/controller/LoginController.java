package com.tech.doks.login.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tech.doks.login.controller.LoginController;
import com.tech.doks.login.svc.LoginService;
import com.tech.doks.login.svc.impl.LoginServiceImplDsSpring;

@Controller
public class LoginController {

	static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginServiceImplDsSpring loginServiceImplDsSpring;
	/*public LoginService loginService = null; 
	
	public void setUserService(LoginService loginService) {
		this.loginService = loginService;
	}*/

	public void setLoginServiceImplDsSpring(
			LoginServiceImplDsSpring loginServiceImplDsSpring) {
		this.loginServiceImplDsSpring = loginServiceImplDsSpring;
	}

	@RequestMapping(value = "/CheckUser", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userName,
			@RequestParam String password, ModelMap model) {
		String retVal = "invalid";
		model.addAttribute("loginError", "Invalid User Name or Password");
		try {
			System.out.println("userName--->" + userName + "\n" + "password--->" + password);
			boolean b = loginServiceImplDsSpring.authenticate(userName, password);
			logger.error("is authenticated ::" + b);
			if (b) {
				model.addAttribute("userName", userName);
				retVal = "home";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;
	}

}
