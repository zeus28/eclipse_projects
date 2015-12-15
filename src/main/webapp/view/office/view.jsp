<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${office.name}</title>
</head>
<body>
		<h1>${office.name}</h1>
		<!-- TODO: list offices -->
		<a href="${office.url}&edit">edit contact</a>
		<a href="${office.company.url}">back to ${office.company.name}</a>
</body>
</html>