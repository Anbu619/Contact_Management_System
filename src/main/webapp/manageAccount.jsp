<%@page import="com.ex.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Manage Your Account</h1>
		<% 
			User user = (User)session.getAttribute("user"); 
			if(user != null ){
		%>
		<p>Name : <%= user.getUserName() %></p>
		<p>Email : <%= user.getEmail() %></p>
		<p>Password : <%= user.getPassword() %></p>
		<a href="updateAccount.jsp">update Account</a>
		<a href="deleteUser">delete Account</a>
		<% } %>
	</div>
</body>
</html>