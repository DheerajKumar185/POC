<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%-- <%
    String name = null;
    response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
    response.addHeader("Pragma", "no-cache"); 
    response.addDateHeader ("Expires", 0);   
    try
    {
    	name = ((String)session.getAttribute("Name")).toUpperCase();
    }
    catch(Exception e)
    {
    	System.out.println("An error has occured");
    	response.sendRedirect("login.jsp");
    }
    System.out.println("Name --->" + name);
    %> --%>
        
    <%--
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);    
     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1 align="center"><font color="green">Welcome !!!</font> <font color="maroon"> ${userName}</font></h1>
</body>
</html>