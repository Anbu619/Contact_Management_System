<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp"%>

<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="Stylesheets/form.css">
<style>
form {
	
}
</style>
</head>
<body>
	<div>
		<h1>Login</h1>
		<form action="login" method="post">
			<label>Enter Email :</label> 
			<input type="text" name="email">
			<label>Enter Password :</label> 
			<input type="password" name="password"> 
			<input type="submit" value="LOGIN">
		</form>
	</div>
</body>
</html>