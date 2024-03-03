<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="e" action="register" method="post">
		<form:label path="name">Name: </form:label>
		<form:input path="name" />
		<br>

		<form:label path="phone">Phone: </form:label>
		<form:input path="phone" />
		<br>

		<form:label path="email">Email: </form:label>
		<form:input path="email" />
		<br>
		
		<form:label path="gender">Gender: </form:label>
		<form:radiobutton path="gender" value="male" />Male
	    <form:radiobutton path="gender" value="female" />Female <br>
	    
	    <form:label path="salary">Salary: </form:label>
		<form:input path="salary" /> <br>

		<form:button>Register</form:button>
	</form:form>
</body>
</html>