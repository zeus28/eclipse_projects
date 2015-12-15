<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>All Contacts</h1>
	<ul>
		<c:forEach var ="contact" items = "${contacts}">
			<li><a href="${contact.url}">${contact.id} ${contact.name}</a></li>
		</c:forEach>
	</ul>
	<a href="person?add">add new person</a>
	<a href="company?add">add new company</a>
	
</body>
</html>