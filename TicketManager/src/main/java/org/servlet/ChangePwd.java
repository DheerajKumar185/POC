package org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.main.ConnectionManager;

/**
 * Servlet implementation class ChangePwd
 */
public class ChangePwd extends HttpServlet {
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String user = (String)session.getAttribute("Name");
		String pwd = request.getParameter("pwd1");
		String status = new ConnectionManager().ChangePwd(user, pwd);
		System.out.println("status-->" + status);
		System.out.println("User Name " + user + "\n" + "Password " + pwd);
		if(status.equals("Failed"))
		{
			response.sendRedirect("error.jsp");
		}
		else
		{
			response.sendRedirect("success.jsp");			
		}
	}

}
