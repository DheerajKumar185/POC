package com.tech.doks.login.svc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tech.doks.login.svc.LoginService;

public class LoginServiceImplJdbc implements LoginService {

	public boolean authenticate(String userName, String password) {
		System.out.println(" Impl:: " + this);
		boolean isAuthenticated = false;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:Detail_DB");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Detail where user_Name='"
					+ userName + "' and password='" + password + "';");
			if (rs.next()) {
				isAuthenticated = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isAuthenticated;
	}

}
