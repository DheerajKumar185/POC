package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.main.ConnectionManager;

/**
 * Servlet implementation class CheckUser2
 */
@WebServlet("/CheckUser2")
public class CheckUser2 extends HttpServlet {
	static Connection conn;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		String status = ConnectionManager.getConnection(userName,password);
		System.out.println("Conn--->" + status);
		if(status.equals("Success"))
		{
			System.out.println("Success");
			HttpSession session=request.getSession();
            session.setAttribute("Name", userName);
			response.sendRedirect("home.jsp");
		}
		else
		{
			System.out.println("Failed");
			response.sendRedirect("invalid.jsp");
		}		
	}
}