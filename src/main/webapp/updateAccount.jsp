<%@page import="com.ex.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="Stylesheets/form.css">
</head>
<body>
	<div>
		<% User user = (User)session.getAttribute("user"); %>
		<h1>Update Profile</h1>
		<form action="updateAccount" method="post">
			<label>Enter Name :</label>
			<input type="text" name="userName" value="<%=user.getUserName() %>">
			<label>Enter Email :</label>
			<input type="email" name="email" value="<%=user.getEmail() %>">
			<label>Enter Password :</label>
			<input type="password" name="password" value="<%=user.getPassword() %>">
			<input type="submit" value="UPDATE">
		</form>
	</div>
</body>
</html>