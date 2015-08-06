package org.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.businessrule.ExceptionUtil;

public class ConnectionManager {
	private static Logger LOG = Logger.getLogger(ConnectionManager.class
			.getName());
	private static Connection conn = null;
	
	public static String getConnection(String userName, String password) {
		String result = null;
		Statement stmt = null;
		ResultSet rs = null;
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		String dbName = "Detail_DB";
		// String connectionURL = "jdbc:derby:" + dbName + ";create=true";
		String connectionURL = "jdbc:derby:" + dbName + ";";
		// String createString =
		// "CREATE TABLE Detail (user_Name VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL, Address VARCHAR(50) NOT NULL)";
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
			// stmt = conn.createStatement();
			// stmt.executeUpdate(createString);

			// PreparedStatement psInsert = conn
			// .prepareStatement("insert into Detail values (?,?,?)");
			//
			// psInsert.setString(1, "Kamal");
			// psInsert.setString(2, "Pass");
			// psInsert.setString(3, "Front of IBM Company");
			//
			// psInsert.executeUpdate();
			// System.out.println("Value Inserted");

			stmt = conn.createStatement();
			System.out.println("userName--->" + userName + "\t"
					+ "password--->" + password);
			rs = stmt.executeQuery("select * from Detail where user_Name="
					+ "'" + userName + "'" + " and password=" + "'" + password
					+ "'");

			boolean found = rs.next();
			// System.out.println();
			// System.out.println(found);
			System.out.println("User_Name" + "\t" + "Address");
			if (found) {
				System.out.println("Success");
				System.out.println(rs.getString(1) + "\t" + rs.getString(3));
				result = "Success";
			} else {
				System.out.println("Failed");
				result = "Failed";
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					LOG.error("Error in ConnectionManager.getConnection catch block ResultSet cannot close------->" + new ExceptionUtil().getStackTrace(e));
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					LOG.error("Error in ConnectionManager.getConnection catch block statment cannot close------->" + new ExceptionUtil().getStackTrace(e));					
				}
				stmt = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String ChangePwd(String user, String pwd) {
		String result = null;
		try {
			System.out.println("user--->" + user + "\t" + "pwd--->" + pwd);
			PreparedStatement ps = null;
			ps=conn.prepareStatement("update Detail set password=? where user_Name=?");
            ps.setString(1, pwd);
            ps.setString(2, user);
            ps.executeUpdate();
//			
//			String sql = "update Detail set password='" + pwd + "' where user_Name='" + user + "'";
//			stmt = conn.createStatement();
//			LOG.debug("SQL for change pwd--->" + sql);
//			System.out.println("Query --->" + stmt.executeUpdate(sql));
			// ps=conn.prepareStatement("alter user " + user + " identified by "
			// + pwd);
			// ps.setString(1, user);
			// ps.setString(2, pwd);
			// ps.executeUpdate();
			System.out.println("Password is updated");
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					LOG.error("Error in ConnectionManager.ChangePwd catch block statment cannot close------->" + new ExceptionUtil().getStackTrace(e));					
				}
				ps = null;
			}
			result = "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String ConnClose() {
		String result = null;
		if (conn != null) {
			try {
				conn.close();
				result = "Closed";
				System.out.println("Close the connection");
			} catch (SQLException e) {
				LOG.error("Error occure while close the connection ------->"
						+ new ExceptionUtil().getStackTrace(e));
			}
			conn = null;
		}
		return result;
	}
}