package com.tech.doks.login.svc.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;





import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.tech.doks.login.svc.LoginService;

public class LoginServiceImplDsSpring implements LoginService{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		if(dataSource != null){
			System.out.println("datasource is not null ::");	
		}
		
		System.out.println("setter this" + this);
		System.out.println("setter hashcode "+this.hashCode());
		
		this.dataSource = dataSource;
	}

	public boolean authenticate(String userName, String password) {
		boolean isAuthenticated = false;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			System.out.println("kamal::");
			System.out.println("method userName--->" + userName + "\n" + "password--->" + password);
			System.out.println("method this" + this);
			System.out.println("method hashcode "+this.hashCode());

			if(dataSource != null){
				System.out.println(" inside datasource is not null ::");	
			}else{
				System.out.println("inside datasource is null");
			}
			
			conn = dataSource.getConnection();
			System.out.println("after connection creation");
			stmt = conn.createStatement();
			System.out.println("after statement creation");
			rs = stmt
					.executeQuery("select * from Detail where user_Name='" + userName + "' and password='" + password
							+ "'");
			
			System.out.println("after resulset received ::");
			if (rs.next()) {
				isAuthenticated = true;
			}
			System.out.println("isAuthenticated::"+isAuthenticated);

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