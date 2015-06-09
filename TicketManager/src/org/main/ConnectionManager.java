package org.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static Connection conn = null;
	private static Statement stmt;
	private static ResultSet rs;
	static String result = null;
	public static String getConnection(String userName, String password){
		
	    
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName = "Derby_DB0";
//	    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
	    String connectionURL = "jdbc:derby:" + dbName + ";";
//	    String createString = "CREATE TABLE Detail2 (user_Name VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL, Address VARCHAR(50) NOT NULL)";
	    try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
			 conn = DriverManager.getConnection(connectionURL);
			 System.out.println("Connection created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(createString);

//		    PreparedStatement psInsert = conn
//		        .prepareStatement("insert into Detail2 values (?,?,?)");
//
//		    psInsert.setString(1, "Kamal");
//		    psInsert.setString(2, "Pass");
//		    psInsert.setString(3, "Front of IBM Company");
//
//		    psInsert.executeUpdate();
//		    System.out.println("Value Inserted");
		    
		    Statement stmt = conn.createStatement();
		    System.out.println("userName--->" + userName + "\t" + "password--->" + password);
		    rs = stmt.executeQuery("select * from Detail2 where user_Name=" + "'" + userName + "'" + " and password=" + "'" + password + "'");
	    
		    boolean found = rs.next();
//		    System.out.println();
		    //System.out.println(found);
		    System.out.println("User_Name" + "\t" + "Address");
			if (found)
			{		    
				System.out.println("Success");
				System.out.println(rs.getString(1) + "\t" + rs.getString(3));
				result = "Success";
			}
			else
			{
				System.out.println("Failed");
				result = "Failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return result;
	}
	public String ConnClose()
	{
		if(conn != null)
		{
			try {
				conn.close();
				result = "Closed";
				System.out.println("Close the connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
		return result;
	}
}