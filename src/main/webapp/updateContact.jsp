<%@page import="com.ex.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="Stylesheets/form.css">
</head>
<body>
	<div>
		<% Contact contact = (Contact)request.getAttribute("contact"); %>
		<h1>Update contact</h1>
		<form action="updateContact" method="post">
			<input type="text" name="contactId" value="<%=contact.getContactId()%>" hidden="true">
			<label>Enter Contact Name :</label>
			<input type="text" name="contactName" value="<%=contact.getContactName()%>">
			<label>Enter Contact Number :</label>
			<input type="number" name="contactNumber" value="<%=contact.getContactNumber()%>">
			<input type="submit" value="UPDATE">
		</form>
	</div>
</body>
</html>