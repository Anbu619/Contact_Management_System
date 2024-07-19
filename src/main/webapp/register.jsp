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
		<h1>Register</h1>
		<form action="register" method="post">
			<input type="text" name="userName" placeholder="Enter User Name">
			<input type="email" name="email" placeholder="Enter User Email">
			<input type="text" name="password" placeholder="Enter User Password">
			<input type="submit" value="REGISTER"> 
		</form>
	</div>
</body>
</html>