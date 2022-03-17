<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<div>
		<h2>Employee Login</h2>
		<br>
		<form action="Login" method="post">
			<label for="empid">EmployeeID </label><input type="text" name="employee_id" required="required"/>
			<br><br>
			<label for="password">Password </label><input type="password" id="password" name="password" required="required" />
			<br><br>
			<button type="reset">Cancel</button>
			<br><br>
			<button type="submit" style="background: #DF4E18;">Login</button>
			<br><br>
			<a href="signup.jsp">Signup</a>
		</form>
	</div>
</body>
</html>