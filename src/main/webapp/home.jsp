<%@page import="com.ex.service.ManageAccount"%>
<%@page import="com.ex.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="Stylesheets/home.css">

</head>
<body>
	<% 
		User user = (User)session.getAttribute("user");  
		String addContact = user != null ? "addContact.jsp" :"login.jsp";
		String manageContact = user != null ? "manageContact" :"login.jsp";
		String manageAccount= user != null ? "manageAccount.jsp" :"login.jsp";
	%>
	
	<div id="main">
		<h1>Welcome Back Buddy!!!</h1>
		<a href="<%=addContact%>">Add Contact</a> 
		<a href="<%=manageContact%>">Manage Contact</a> 
		<a href="<%=manageAccount%>">Manage Account</a>
	</div>
</body>
</html> 