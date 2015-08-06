<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language=javascript>
            function updateTime()
            {
                var dt=new Date();
                var v = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();
                setTimeout("updateTime()",1000);
                document.getElementById('time').innerHTML=v;
            }
            updateTime();
                    </script>
</head>
<body>
<table align="right">
	<tr>
		<td><a href="home.jsp">profile</a></td>
		<td>&nbsp;</td>
		<td><a href="changepwd.jsp">change password</a></td>
		<td>&nbsp;</td>
		<td><a href="Logout">logout</a></td>				
	</tr>	
</table><br>
<h3 align="left">Time:   <span id="time"></span></h3>
</body>
</html>