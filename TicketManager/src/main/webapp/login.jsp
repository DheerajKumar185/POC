<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="CheckUser" method="post">
	<pre>
		User Name : <input type="text" name="userName" placeholder="userName"><br>
		Password : <input type="password" name="password" placeholder="password"><br>
		<br>
		<input type="submit" value="Submit">		<input type="reset" value="Reset">
	</pre>
</form>
</body>
</html>