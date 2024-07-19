<%@page import="com.ex.entity.Contact"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Manage Contacts</h1>
	<table>
		<tr>
			<th>Contact Id</th>
			<th>Contact Name</th>
			<th>Contact Number</th>
		</tr>
		<%
		List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
		if (contacts != null) {
			for (Contact contact : contacts) {
		%>
		<tr>
			<td><%=contact.getContactId() %></td>
			<td><%=contact.getContactName() %></td>
			<td><%=contact.getContactNumber() %></td>
			<td><a href="findContact?contactId=<%=contact.getContactId()%>">Edit</a></td>
			<td><a href="deleteContact?contactId=<%=contact.getContactId()%>">Delete</a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	
	<a href="addContact.jsp">Add contact</a>
	<a href="home.jsp">Back</a>
	
</body>
</html>