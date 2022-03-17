<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Employee Signup</h2>
		<br>
		<form action="Signup" method="post">
			<label for="empid">EmployeeID </label><input type="text" name="employee_id" required="required"/>
			<br><br>
			<label for="fname">First Name </label><input type="text" name="fname" required="required" />
			<br><br>
			<label for="lname">Last Name </label><input type="text" name="lname" required="required" />
			<br><br>
			<label for="dob">Date of Birth </label><input type="text" name="dob" required="required" />
			<br><br>
			<label for="contact">Contact Number </label><input type="text" name="contact" required="required" />
			<br><br>
			<label for="job">Job Role </label><input type="text" name="job" required="required" />
			<br><br>
			<label for="salary">Salary </label><input type="text" name="salary" required="required" />
			<br><br>
			<label for="yearbonus">Yearly Bonus </label><input type="text" name="yearbonus" required="required" />
			<br><br>
			<label for="password">Password </label><input type="password" name="password" required="required" />
			<br><br>
			<button type="reset">Cancel</button>
			<br>
			<br>
			<button type="submit" style="background: #DF4E18;">Signup</button>
			<br><br>
			<a href="login.jsp">Login</a>
		</form>
	</div>
</body>
</html>