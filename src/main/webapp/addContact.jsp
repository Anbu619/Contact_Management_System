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
		<h1>Add contacts</h1>
		<form action="addContact" method="post">
			<label>Enter Contact Name :</label>
			<input type="text" name="contactName" >
			<label>Enter Contact Number :</label>
			<input type="number" name="contactNumber" placeholder="">
			<input type="submit" value="ADD">
		</form>
	</div>
</body>
</html>