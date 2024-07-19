<%@page import="com.ex.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Stylesheets/nav.css">
</head>
<body>
	<nav>
		<h2 id="logo"><a href="home.jsp">Contact Management System</a></h2>
		<%
		User user2 = (User) session.getAttribute("user");
		if (user2 == null) {
		%>
		<div class="btn">
			<a href="register.jsp">Register</a> 
			<a href="login.jsp"> Login</a>
		</div>
		<%
		} else {
		%>
		<div class="btn">
			<a href="logout">Logout</a>
		</div>
		<%
		}
		%>
	</nav>

</body>
</html>