<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ChangePwd" method="post">
<table align="center">
	<tr><th colspan="3">Change Password</th></tr>
	<tr></tr>
	<tr>
		<td>New Password</td>
		<td>:</td>
		<td><input type="password" name="pwd1"></td>
	</tr>
	<tr>
		<td>Confirm Password</td>
		<td>:</td>
		<td><input type="password" name="pwd2"></td>
	</tr>
	<tr></tr>
	<tr>
		<td><input type="submit" value="Save"></td>
		<td><input type="reset" value="Reset"></td>
		
	</tr>
</table>
</form>
</body>
</html>