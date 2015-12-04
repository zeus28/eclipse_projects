<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<h1>Start Section</h1>
		<c:forEach var ="name" items = "${names}">
			<h2>Hello, ${name}! </h2>
		</c:forEach>
		<h1>End Section</h1>
	</body>
</html>