<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Company</title>
</head>
<body>
		<h1>Add Company</h1>
		<form action ="company?add" method="post">
		<input type ="hidden" name ="add"/>
			<ul>
				<li>name : <input type="text" name ="name" /></li>
			</ul>
			<input type ="submit" value ="add" />
		</form>
		<a href="contacts">back to contact list</a>
</body>
</html>