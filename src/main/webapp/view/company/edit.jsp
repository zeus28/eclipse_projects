<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Company</title>
</head>
<body>
		<h1>Edit Company</h1>
		<form action ="company?edit" method="post">
		<input type ="hidden" name ="edit"/>
		<input type ="hidden" name ="id" value ="${company.id}"/>
			<ul>
			 	<li>name : <input type="text" name ="name"  value = "${company.name}"/></li>
		   </ul>
			<input type ="submit" value ="edit" />
		</form>
		<form action="company?delete" method="post">
			<input type ="hidden" name ="id" value ="${company.id}"/>
			<input type ="submit" value ="delete" />
		</form>
		<a href="contacts">back to contact list</a>
</body>
</html>